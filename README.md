# Unit testing In Java (JUnit & Mockito)
## Introduction to Unit Testing
1. **Overview**:
Unit testing is the process where you test the smallest functional unit of code in an application. In Java, the smallest functional unit of code is a method. 
Unit testing is important because it helps you to identify bugs early in the development process and also helps you to ensure that your code is working as expected.
Unit testing is also important because it helps you to write better code by forcing you to think about how your code should work before you write it.
Unit testing is also important because it helps you to write more maintainable code by making it easier to refactor your code without breaking it or testing it with every change.
2. **Naming Conventions**:
In fact there are tons of naming conventions for unit tests, what matters is that you are consistent with your naming conventions.
some examples are:
- ``MethodName_StateUnderTest_ExpectedBehavior``
  - cons: should be renamed if method change name
  - example: isAdult_AgeLessThan18_False
- ``testFeatureBeingTested``
  - cons: “test” prefix is redundant
  - example: testIsNotAnAdultIfAgeLessThan18 or test_IsNotAnAdult_IfAgeLessThan18
- ``Should_ExpectedBehavior_When_StateUnderTest``
  - cons: duplicates `should` and `when`, long name
  - example: Should_ThrowException_When_AgeLessThan18

## What is JUnit?
Junit is a unit testing framework for Java that helps you to write and run unit tests.
Junit provides a set of annotations and assertions that you can use to write unit tests for your code.
Junit also provides a test runner that you can use to run your unit tests and generate reports on the results.
Junit is widely used in the Java community and is the de facto standard for unit testing in Java.
a test is considered successful if it completes without any failures or errors.

## Starting with JUnit
1. **Assertions**: JUnit provides a set of assertions that you can use to test the output of your code. 
    For example, you can use the `assertEquals()` method to test if two values are equal. if an assertion fails, the test is considered a failure.
2. **Annotations**: JUnit provides a set of annotations that you can use to define your test methods. 
- `@Test`: This annotation is used to mark a method as a test method.
- `@BeforeEach`: This annotation is used to mark a method that should be run before each test method.
- `@AfterEach`: This annotation is used to mark a method that should be run after each test method.
- `@BeforeAll`: This annotation is used to mark a method that should be run before all test methods(before starting the tests).
- `@AfterAll`: This annotation is used to mark a method that should be run after all test methods(after finishing the tests).
- `@Suite`: This annotation is used to mark a class as a suite of test classes.


# Getting Started with Mockito
### 1. Stub: Definition, Advantages, and Disadvantages

A **stub** is a simple, temporary implementation of an interface used in unit testing to simulate the behavior of a dependency.

**Advantages:**
1. **Isolation**: Allows testing without relying on external components.
2. **Simplicity**: Easy to create for basic scenarios.
3. **Speed**: Fast execution since no external resources are involved.

**Disadvantages:**
1. **Limited Flexibility**: Hardcoded responses make it difficult to test varied scenarios.
2. **Maintenance**: Requires updates as the system evolves.
3. **Complexity**: Becomes cumbersome for dynamic or complex behavior.

Stubs are best for simple tests; for more complex cases, mocks are often a better choice.

### 2. Mocks, Mockito, and the Advantages of Mocking

**Mocks**: A mock is a test double used in unit testing to simulate the behavior of real objects. Unlike stubs, mocks allow for more dynamic interactions, such as verifying how many times a method was called.

**Mockito**: Mockito is a popular Java-based framework used for creating mocks. It simplifies the process of creating mock objects and setting up their expected behavior during tests.

**Advantages of Mocking**:
1. **Flexibility**: Easily simulate different scenarios without hardcoding responses.
2. **Verification**: Check interactions with the mock, like method calls, to ensure correct behavior.
3. **Isolation**: Test components in isolation from external dependencies, leading to more reliable and faster tests.

Mocking, especially with Mockito, provides a powerful toolset for ensuring that your tests are both comprehensive and maintainable.