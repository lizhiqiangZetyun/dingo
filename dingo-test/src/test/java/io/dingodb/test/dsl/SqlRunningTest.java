/*
 * Copyright 2021 DataCanvas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.dingodb.test.dsl;

import io.dingodb.test.dsl.builder.SqlTestCaseYamlBuilder;
import io.dingodb.test.dsl.run.SqlTestRunner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class SqlRunningTest extends SqlTestRunner {
    @TestFactory
    public Stream<DynamicTest> testBasicDml() {
        return getTests(new BasicDmlCases());
    }

    @TestFactory
    public Stream<DynamicTest> testBasicQuery() {
        return getTests(new BasicQueryCases());
    }

    @TestFactory
    public Stream<DynamicTest> testCollectionDml() {
        return getTests(new CollectionDmlCases());
    }

    @TestFactory
    public Stream<DynamicTest> testCollectionQuery() {
        return getTests(new CollectionQueryCases());
    }

    @TestFactory
    public Stream<DynamicTest> testDateTimeQuery() {
        return getTests(new DateTimeQueryCases());
    }

    @TestFactory
    public Stream<DynamicTest> testI40VsF8kQuery() {
        return getTests(SqlTestCaseYamlBuilder.of("i40_vs_f8k/query_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testI4kF80Query() {
        return getTests(SqlTestCaseYamlBuilder.of("i4k_f80/query_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testI4kL0Dml() {
        return getTests(SqlTestCaseYamlBuilder.of("i4k_l0/dml_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testI4kVsL0Query() {
        return getTests(SqlTestCaseYamlBuilder.of("i4k_vs_l0/query_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testParameterDml() {
        return getTests(new ParameterDmlCases());
    }

    @TestFactory
    public Stream<DynamicTest> testParameterQuery() {
        return getTests(new ParameterQueryCases());
    }

    @TestFactory
    public Stream<DynamicTest> testJoin() {
        return getTests(SqlTestCaseYamlBuilder.of("join_i4k_vs_i4__i4k_vs_2/join_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testJoin1() {
        return getTests(SqlTestCaseYamlBuilder.of("join_i4k_vs0_i40__i4k_vs/join_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testJoin2() {
        return getTests(SqlTestCaseYamlBuilder.of("join_i4k_vs0_5_f80_2_i40_2_ts0__i4k_vs0_i40_2/join_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testJoin3() {
        return getTests(SqlTestCaseYamlBuilder.of("join_i4k_vs_vs0_ts0_vs_i40__i4k_vs_i4/join_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testSelfJoin() {
        return getTests(SqlTestCaseYamlBuilder.of("i4k_vs0_i40/self_join_cases.yml"));
    }

    @TestFactory
    public Stream<DynamicTest> testTransfer() {
        return getTests(new TransferCases());
    }

    @Disabled
    @TestFactory
    public Stream<DynamicTest> testStressDml() {
        return getTests(new StressDmlCases());
    }
}
