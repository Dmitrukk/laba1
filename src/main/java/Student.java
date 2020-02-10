public class Student {
    String surname;  // Фамилия
    String name;   // Имя
    String mark;     // Предмет
    String course;      // оценка

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student(String surname, String name, String mark, String course)
    {
        this.surname = surname;
        this.name = name;
        this.mark = mark;
        this.course = course;
    }

    public Student() {

    }

    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getMark() { return mark; }
    public String getCourse() { return course; }

    public static void main(String[] args) {
    }
}