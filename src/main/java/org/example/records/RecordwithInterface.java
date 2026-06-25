

public record User(int id, String name, int age) implements TestInterface {
}

;

interface TestInterface {
    default void test() {
        System.out.println("Test method in interface");
    };
}

void main() {
    IO.println("Hello World!");

    User user = new User(1, "John", 30);

    user.test();
    IO.println(user);
}


