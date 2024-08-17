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
## 1. Stub: Definition, Advantages, and Disadvantages

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

## 2. Mocks, Mockito, and the Advantages of Mocking

**Mocks**: A mock is a test double used in unit testing to simulate the behavior of real objects. Unlike stubs, mocks allow for more dynamic interactions, such as verifying how many times a method was called.

**Mockito**: Mockito is a popular Java-based framework used for creating mocks. It simplifies the process of creating mock objects and setting up their expected behavior during tests.

**Advantages of Mocking**:
1. **Flexibility**: Easily simulate different scenarios without hardcoding responses.
2. **Verification**: Check interactions with the mock, like method calls, to ensure correct behavior.
3. **Isolation**: Test components in isolation from external dependencies, leading to more reliable and faster tests.

Mocking, especially with Mockito, provides a powerful toolset for ensuring that your tests are both comprehensive and maintainable.

## 3. BDD (Behavior-Driven Development) with Mockito

**Behavior-Driven Development (BDD)** is a development approach that involves writing tests in a way that focuses on the behavior of an application from the end user's perspective. It bridges the gap between technical and non-technical team members by using plain language structured around user stories.

### **Why Use BDD?**
- **Collaboration:** Enhances communication between developers, testers, and business stakeholders.
- **Clarity:** Provides a clear understanding of the expected behavior of a system.
- **Test Automation:** BDD tests can be automated, which ensures the code meets the business requirements.

### **Given-When-Then Structure:**
- **Given:** Sets up the initial context or preconditions (e.g., initial state or data setup).
- **When:** Describes the action or event that triggers the behavior.
- **Then:** Defines the expected outcome or post-condition resulting from the action.

### **Key Notes:**
1. **Combination of Matchers and Hardcoded Values:** Mockito does not allow mixing matchers (like `anyInt()`) with hardcoded values (e.g., `5`). You must be consistent by either using matchers or specific values entirely.
2. **Mocking List Methods:** Practice mocking various methods of a list and observe how they behave, particularly when unstubbed methods are called (e.g., returning default values like `0` for integers).
3. **Unstubbed Method Behavior:** Understand that unstubbed methods in a mock return default values such as `null` for objects, `false` for booleans, and `0` for integers.

### **Implementing BDD in Mockito:**
- **Given:** Use `BDDMockito.given()` to set up the preconditions.
- **When:** This is the action under test.
- **Then:** Use `assertThat()` for more readable assertions compared to traditional `assertEquals()`.

This method of organizing tests helps to make them more readable, structured, and aligned with user stories. You can practice converting existing tests to the BDD style to gain a deeper understanding.


### Verifying Calls in Mockito
- **Purpose**: Verification in Mockito is used to check if a specific method on a mock object was called during testing.
- **How to Verify**:
  - Use `verify(mockObject).methodName(argument)` to check if a method was called with a specific argument.
  - `verify(mockObject, times(n)).methodName(argument)` checks if the method was called `n` times.
  - `verify(mockObject, never()).methodName(argument)` ensures the method was not called with the specified argument.
  - `verify(mockObject, atLeast(n)).methodName(argument)` ensures the method was called at least `n` times.
- **Common Use Case**: Useful for testing methods that do not return a value but have side effects, such as modifying data or invoking other methods.


## Spy vs. Mock

- **Mock**: A mock is a dummy implementation of a class or interface used in testing. When you mock an object, all methods of the mock object return default values unless explicitly stubbed. The mock does not invoke any real behavior from the underlying object; it's entirely synthetic.

- **Spy**: A spy is a partial mock that allows you to track and alter the behavior of a real object while preserving the original functionality for the parts not explicitly stubbed. Spies enable you to monitor method calls on the real object and selectively override specific methods.

#### Key Differences:
- **Behavior**:
  - *Mock*: Does not use the real object; all interactions are artificial.
  - *Spy*: Uses the real object but allows selective stubbing of methods.

- **Usage**:
  - *Mock*: Used when you want complete control over the object's behavior without relying on any real logic.
  - *Spy*: Used when you need to partially mock an object while still using its real methods.

- **Complexity**:
  - *Mock*: Simpler and easier to maintain because the entire object is mocked.
  - *Spy*: More complex due to the combination of real and mocked behavior, which can make the code harder to understand and maintain.

#### Why Avoid Spies?
- **Maintenance Complexity**: Mixing real and mocked behavior can lead to confusing and harder-to-maintain code, especially in large projects.
- **Use in Legacy Code**: Spies are more appropriate for legacy systems where you cannot modify the original code. In well-designed systems, relying on mocks is generally preferred.


## Understanding Mockito's Design Choices

This design choice is rooted in promoting good object-oriented design and testing practices:

1. **Mockito's Focus**: Mockito encourages testing public interfaces rather than private methods, as this aligns with the principles of good unit testing.

2. **Limitations**: Mockito does not allow mocking of final classes, private methods, or static methods. These limitations are intentional to prevent poor design practices like over-reliance on static methods, which are generally considered bad in object-oriented design.

3. **Alternatives**: While Mockito itself doesn't support these features, other frameworks like PowerMock can be used alongside Mockito to mock final classes or static methods.
