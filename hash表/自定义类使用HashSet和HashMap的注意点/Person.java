package 自定义类使用HashSet和HashMap的注意点;

import java.util.Objects;

public class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        // 复写为0不影响查找，但是是错误的，所有元素都hash冲突了
        //return 0;
        return Objects.hash(name, age);
    }
}
