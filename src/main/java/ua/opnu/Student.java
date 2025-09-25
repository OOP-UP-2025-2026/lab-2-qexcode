package ua.opnu;

public class Student {
    private String name;
    private int year;
    private String[] courses;
    private int courseCount; // кількість доданих дисциплін

    // Конструктор
    public Student(String name, int year) {
        if (year < 1 || year > 4) {
            year = 1; // якщо некоректний рік → ставимо 1
        }
        this.name = name;
        this.year = year;
        this.courses = new String[100]; // максимум 100 дисциплін
        this.courseCount = 0;
    }

    // Додати дисципліну
    public void addCourse(String courseName) {
        if (courseName != null && courseCount < courses.length) {
            courses[courseCount] = courseName;
            courseCount++;
        }
    }

    // Видалити всі дисципліни
    public void dropAll() {
        courseCount = 0; // просто обнуляємо кількість
    }

    // Повертає кількість дисциплін
    public int getCourseCount() {
        return courseCount;
    }

    // Ім'я студента
    public String getName() {
        return name;
    }

    // Вартість навчання
    public int getTuition() {
        return year * 20000;
    }

    // Рік навчання
    public int getYear() {
        return year;
    }
}