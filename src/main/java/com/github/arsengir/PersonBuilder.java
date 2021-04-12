package com.github.arsengir;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder() {
        this.age = -1;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if ((age < 0) || (age > 150)) {
            throw new IllegalArgumentException("Не корректно указали возраст (" + age + "). Возраст должен быть в диапазоне от 0 до 150.");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Вы не указали имя.");
        }
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Вы не указали фамилию.");
        }
        Person person = new Person(name, surname, age);
        person.setAddress(city);

        return person;
    }
}
