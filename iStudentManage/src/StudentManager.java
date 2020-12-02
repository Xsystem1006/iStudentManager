import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> stu = new ArrayList<>();
        while (true) {
            System.out.println("----------欢迎来到学生管理系统----------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择:");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            switch (line) {
                case "1":
                    addStudent(stu);
                    break;

                case "2":
                    removeStudent(stu);
                    break;

                case "3":
                    setStudent(stu);
                    break;

                case "4":
                    getAllStudent(stu);
                    break;

                case "5":
                    System.exit(0);
                    break;
            }
        }
    }

    public static void addStudent(ArrayList<Student> stu) {
        String sid;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入学生学号:");
            sid = sc.nextLine();

            boolean flag = isusd(stu, sid);

            if (flag) {
                System.out.println("该学号被占用！");
            } else {
                break;
            }
        }

        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄:");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地:");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        stu.add(s);

        System.out.println("添加成功!");
    }

    public static Boolean isusd(ArrayList<Student> stu,String sid){
        boolean flag = false;

        for (int i = 0 ; i < stu.size();i++){
            Student s = stu.get(i);
            if (s.getSid().equals(sid)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void removeStudent(ArrayList<Student> stu){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生ID:");
        String sid = sc.nextLine();

        int index = -1;

        for (int i = 0 ; i < stu.size();i++){
            Student s = stu.get(i);
            if (s.getSid().equals(sid)){
                index = i ;
                break;
            }
        }

        if (index == -1){
            System.out.println("查无此人");
        }else{
            stu.remove(index);
            System.out.println("删除成功");
        }
    }

    public static void setStudent(ArrayList<Student> stu){
        Scanner sc= new Scanner(System.in);
        String sid;
        System.out.println("请输入需要修改的学生ID:");
        sid = sc.nextLine();

        System.out.println("请输入新的姓名:");
        String name = sc.nextLine();
        System.out.println("请输入新的年龄:");
        String age = sc.nextLine();
        System.out.println("请输入新的地址:");
        String address= sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        for (int i = 0 ; i < stu.size();i++){
            Student o = stu.get(i);
            if (o.getSid().equals(sid)){
                stu.set(i,s);
            }
        }
    }

    public static void getAllStudent(ArrayList<Student> stu){
        if (stu.size() == 0){
            System.out.println("无信息！");

            return ;
        }

        System.out.println("学号\t\t\t\t姓名\t\t\t\t年龄\t\t\t\t地址");
        for (int i = 0 ; i < stu.size();i++){
            Student s = stu.get(i);
            System.out.println(s.getSid()+"\t\t\t\t"+s.getName()+"\t\t\t\t"+s.getAge()+"岁\t\t\t\t"+s.getAddress());
        }
    }
}
