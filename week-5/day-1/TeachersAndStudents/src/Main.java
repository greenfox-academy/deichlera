public class Main {
    public static void main(String[] args) {

        Student student1=new Student("Eve");
        Teacher teacher1=new Teacher("Alexandria");

        student1.question(teacher1);
        teacher1.teach(student1);
    }
}
