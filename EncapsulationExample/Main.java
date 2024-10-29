package EncapsulationExample;

    public class Main {
        public static void main(String[] args) {
            Student student1 = new Student();
            student1.setId("BH01340");
            student1.setName("Hien");
            student1.setMark(7);
            Student student2 = new Student();
            student2.setId("BH01202");
            student2.setName("Hung");
            student2.setMark(8);
            Student student3 = new Student();
            student3.setId("BH01102");
            student3.setName("Tuan");
            student3.setMark(4);
            System.out.println(  "Id: "+ student1.getId() + " , Name: "+ student1.getName()+" , Mark: "+ student1.getMark());
            System.out.println(  "Id: "+ student2.getId() + " , Name: "+ student2.getName()+" , Mark: "+ student2.getMark());
            System.out.println(  "Id: "+ student3.getId() + " , Name: "+ student3.getName()+" , Mark: "+ student3.getMark());
        }
    }
