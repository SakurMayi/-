
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class DB {
    public static final String ZH = "admin";
    public static final String PW = "123456";
    public static final Scanner sc = new Scanner(System.in);
    public static final String s1 = "score.txt";
    public static final String s2 = "just.txt";


    public static void main(String[] args) throws IOException {
         ArrayList<Student> stu = new ArrayList<>();
        ArrayList<Just> stujust = new ArrayList<>();
        Fimport(stu, stujust);
        while (true) {
            System.out.println("------欢迎来到XCU学生管理系统-----");
            System.out.println("您如果是老师请输入数字1，是学生请输入数字2,输入其他自动关闭系统");
            int x = Integer.parseInt(sc.nextLine().trim());
            if (x == 1) {
                System.out.println("------老师您好，请输入账户和密码（分行写入，输入有误会重新进入）-----");
                Login();

                    while (true) {
                        boolean isprime = true;
                        init();
                        int choose = Integer.parseInt(sc.nextLine().trim());
                        switch (choose) {
                            case 1 -> addStudent(stu, stujust);
                            case 2 -> deletStudent(stu);
                            case 3 -> updateStudent(stu);
                            case 4 -> queryStudent(stu);
                            case 5 -> passStudent(stu, stujust);
                            case 6 -> {
                                Fcopy(s1, "a.txt");
                                System.out.println("退出老师模式");
                                isprime = false;
                            }
                            case 7 -> {
                                Fcopy(s1, "a.txt");
                                System.out.println("关闭学生管理系统");
                                sc.close();
                                System.exit(0);
                            }
                            default -> System.out.println("没有相对应的选项");
                        }
                        if (!isprime)
                            break;
                    }
            } else if (x == 2) {
                Fimport(stu, stujust);
                System.out.println("------欢迎来到XCU学生管理系统-----");
                System.out.println("同学你好。你只有查询成绩的权限");
                while (true) {
                    query1Student(stu, stujust);
                    System.out.println("是继续查询/退出学生模式,输入yes/no,输入其他会退出系统");
                    String ju = sc.nextLine().trim();
                    if (ju.equals("no")) {
                        System.out.println("退出学生模式");
                        break;
                    } else if (ju.equals("yes")) {
                    } else {
                        System.out.println("关闭学生管理系统");
                        sc.close();
                        System.exit(0);
                    }
                }
            } else {
                Fcopy(s1, "a.txt");
                System.out.println("输入错误，已关闭系统");
                sc.close();
                System.exit(0);
            }
        }

    }
    public static void Login(){
        //创建一个主要框架,将其命名为”登录"
        JFrame jFrame = new JFrame("登录");

        //设置窗口大小
        jFrame.setSize(900,507);

        //先将布局管理器置为null
        jFrame.setLayout(null);

        //添加标签【学生管理系统】
        JLabel textStudentManage = new JLabel("学生管理系统");//创建一个标签,并命名为“学生管理系统“
        textStudentManage.setForeground(new Color(0x0010FF));//设置字体颜色
        textStudentManage.setFont(new Font("黑体", Font.PLAIN,50));//设置字体大小
        textStudentManage.setBounds(280,50,800,100);//设置标签的绝对位置
        jFrame.add(textStudentManage);//向框架中添加组件【标签(学生管理系统)】

        //添加标签【用户名】
        JLabel textUser = new JLabel("用户名:");
        textUser.setForeground(new Color(0xFF0000));
        textUser.setFont(new Font("黑体", Font.PLAIN,30));
        textUser.setBounds(200,140,200,100);
        jFrame.add(textUser);

        //添加输入框【用户名输入框】
        JTextField user = new JTextField(20);
        user.setFont(new Font("黑体", Font.PLAIN,18));
        user.setSelectedTextColor(new Color(0xFF0000));
        user.setBounds(330,170,280,40);
        jFrame.add(user);

        //添加标签【密码】
        JLabel textPassword = new JLabel("密码  :");
        textPassword.setForeground(new Color(0xFF0000));
        textPassword.setFont(new Font("黑体", Font.PLAIN,30));
        textPassword.setBounds(200,200,200,100);
        jFrame.add(textPassword);

        //添加密码输入框【密码】
        JPasswordField password = new JPasswordField(20);
        password.setBounds(330,230,280,40);
        jFrame.add(password);

        //添加按钮【登录】
        JButton jButton = new JButton("登录");
        jButton.setForeground(new Color(0x023BF6));
        jButton.setBackground(new Color(0x38FF00));
        jButton.setFont(new Font("黑体", Font.PLAIN,20));
        jButton.setBorderPainted(false);
        jButton.setBounds(300,330,100,50);
        jFrame.add(jButton);
        //对按钮事件进行处理
        jButton.addActionListener((e -> {

            /*
                账号：admin
                密码：123456
             */

            //设定条件
            String pwd = new String(password.getPassword());
            if(user.getText().equals(ZH)){
                if(pwd.equals(PW)){
                    //密码账号正确,进入学生管理系统
                    //进入学生管理系统
                    jFrame.setVisible(false);//将登录界面设定为不可见
                }else{
                    //密码不正确
                    JOptionPane.showMessageDialog(jFrame,"密码错误","提示",JOptionPane.INFORMATION_MESSAGE);
                    //将密码框置空
                    password.setText("");
                }
            }else{
                //用户名错误
                JOptionPane.showMessageDialog(jFrame,"用户名错误","提示",JOptionPane.INFORMATION_MESSAGE);
                //将用户名和密码置空
                user.setText("");
                password.setText("");
            }
        }));

        //设置相对位置：屏幕中间
        jFrame.setLocationRelativeTo(null);

        //确保使用窗口关闭按钮，能够正常退出，结束进程！
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //禁止对窗口大小进行缩放处理
        jFrame.setResizable(false);

        //设置可见
        jFrame.setVisible(true);
    }


    public static void init() {
        System.out.println("------欢迎来到XCU学生管理系统-----");
        System.out.println("         1:增加学生信息         ");
        System.out.println("         2:删除学生信息         ");
        System.out.println("         3:修改学生信息         ");
        System.out.println("         4:查询学生信息         ");
        System.out.println("         5:查看及格情况         ");
        System.out.println("         6:退出老师模式         ");
        System.out.println("         7:退出学生系统         ");
        System.out.println("请输入您的选择：");
    }

    public static void addStudent(ArrayList<Student> stu, ArrayList<Just> stujust) throws IOException {
        while (true) {
            System.out.println("请依次输入学生的信息：学号(满足10位) 姓名 数学成绩 英语成绩 java成绩");
            String line = sc.nextLine().trim();
            String[] data = line.split("\\s+");
            String id = data[0];
            if (id.length() != 10) {
                System.out.println("学号输入错误");
            } else {
                String name = data[1];
                double Mathscore = Double.parseDouble(data[2]);
                double Englishscore = Double.parseDouble(data[3]);
                double Javascore = Double.parseDouble(data[4]);
                Student a = new Student(id, name, Mathscore, Englishscore, Javascore);
                Just c = new Just(id, name, Mathscore, Englishscore, Javascore);
                int index = IDCX(stu, id);
                if (index == -1) {
                    stu.add(a);
                    stujust.add(c);
                    System.out.println("添加成功。");
                    Fbc(stu);
                } else {
                    System.out.println("该学号重复，添加失败。");
                }
            }
            System.out.println("继续输入信息or退出添加功能，请输入yes/no,输入其他自动退出该功能");
            String ch = sc.nextLine().trim();
            if (ch.equals("no")) {
                System.out.println("已退出添加功能");
                return;
            } else if (ch.equals("yes"))
                ;
            else {
                System.out.println("输入错误，已自动退出添加功能");
                return;
            }
        }
    }

    public static void deletStudent(ArrayList<Student> stu) throws IOException {
        System.out.println("请输入要删除的学生的学号：");
        String id = sc.nextLine().trim();
        int index = IDCX(stu, id);
        if (index != -1) {
            stu.remove(index);
            System.out.println("学号为：" + id + "的学生信息删除成功。");
            Fbc(stu);
        } else {
            System.out.println("学号不存在，删除失败。");
        }
    }

    public static void updateStudent(ArrayList<Student> stu) throws IOException {
        String ch;
        System.out.println("请输入要修改的学生的学号：");
        String id = sc.nextLine().trim();
        // 遍历集合并查找输入的id
        int index = IDCX(stu, id);
        if (index == -1) {
            System.out.println("学号不存在，已退出修改功能。");
            return;
        } else {
            Student s = stu.get(index);
            System.out.println("全部信息修改输入数字1");
            System.out.println("部分信息修改输入数字2");
            System.out.println("输入其他会自动退出修改系统");
            String l = sc.nextLine().trim();
            if (Integer.parseInt(l) == 1) {
                while (true) {
                    System.out.println("请输入该学生的全部信息：（格式为：学号 姓名 数学成绩 英语成绩 java成绩）");
                    String sco = sc.nextLine().trim();
                    String[] data = sco.split("\\s+");
                    s.setStuid(data[0]);
                    s.setName(data[1]);
                    s.setMathscore(Double.parseDouble(data[2]));
                    s.setEnglishscore(Double.parseDouble(data[3]));
                    s.setJavascore(Double.parseDouble(data[4]));
                    s.setScoreSum();
                    s.setAverageSum();
                    Fbc(stu);
                    System.out.println("修改成功");
                    System.out.println("是否重新修改y/n:");
                    ch = sc.nextLine().trim();
                    if (ch.equals("n")) {
                        System.out.println("已退出修改功能。");
                        return;
                    } else if (ch.equals("y"))
                        ;
                    else {
                        System.out.println("输入无效，已自动退出该功能。");
                        return;
                    }

                }

            } else if (Integer.parseInt(l) == 2) {
                while (true) {
                    System.out.println(
                            "请输出要修改的项目数字：\n" + "数字0：修改id\n" + "数字1：name\n" + "数字2：Mathscore\n" + "数字3：Englishscore\n"
                                    + "数字4：Javascore\n");
                    int x = Integer.parseInt(sc.nextLine().trim());
                    switch (x) {
                        case 0:
                            System.out.println("请输入该学生的新的学号：");
                            String sid = sc.nextLine().trim();
                            s.setStuid(sid);
                            Fbc(stu);
                            System.out.println("修改成功");
                            break;
                        case 1:
                            System.out.println("请输入该学生的新的姓名：");
                            String name = sc.nextLine().trim();
                            s.setName(name);
                            Fbc(stu);
                            System.out.println("修改成功");
                            break;
                        case 2:
                            System.out.println("请输入该学生的新的Mathscore：");
                            double Mathscore = Double.parseDouble(sc.nextLine().trim());
                            s.setMathscore(Mathscore);
                            s.setScoreSum();
                            s.setAverageSum();
                            Fbc(stu);
                            System.out.println("修改成功");
                            break;
                        case 3:
                            System.out.println("请输入该学生的新的Englishscore：");
                            double Englishscore = Double.parseDouble(sc.nextLine().trim());
                            s.setEnglishscore(Englishscore);
                            s.setScoreSum();
                            s.setAverageSum();
                            Fbc(stu);
                            System.out.println("修改成功");
                            break;
                        case 4:
                            System.out.println("请输入该学生的新的Javascore：");
                            double Javascore = Double.parseDouble(sc.nextLine().trim());
                            s.setJavascore(Javascore);
                            s.setScoreSum();
                            s.setAverageSum();
                            Fbc(stu);
                            System.out.println("修改成功");
                            break;
                        default:
                            System.out.println("输入错误");
                            break;
                    }
                    System.out.println("是否继续y/n:");
                    ch = sc.nextLine().trim();
                    if (ch.equals("n")) {
                        System.out.println("已退出修改功能。");
                        return;
                    } else if (ch.equals("y"))
                        ;
                    else {
                        System.out.println("输入无效，已自动退出该功能。");
                        return;
                    }
                }

            } else {
                System.out.println("输入无效，已自动退出该功能。");
                return;
            }
        }
    }

    public static void queryStudent(ArrayList<Student> stu) throws IOException {

        if (stu.size() == 0) {
            System.out.println("本系统未添加学生信息，请先添加后，再查询");
            return;
        } else {
            while (true) {
                System.out.println("1.学号排序\n" + "2.平均成绩排序\n" + "输入序号:");
                int x = Integer.parseInt(sc.nextLine().trim());
                if (x == 1) {
                    Collections.sort(stu);// 按学号排序
                    // 清空文件
                    Fclose(s1);
                    // 文件写入
                    FileOutputStream fos = new FileOutputStream(s1, true);

                    byte[] byts = "学号      \t姓名  \t数学成绩\t英语成绩\tJava成绩\t总分成绩\t平均成绩".getBytes();
                    fos.write(byts);
                    byte[] bytes = "\r\n".getBytes();
                    fos.write(bytes);
                    for (Student a : stu) {
                        String line = a.toString();
                        byte[] byts1 = line.getBytes();
                        fos.write(byts1);
                        byte[] bytes1 = "\r\n".getBytes();
                        fos.write(bytes1);
                    }
                    fos.close();
                    System.out.println("学号      \t姓名  \t数学成绩\t英语成绩\tJava成绩\t总分成绩\t平均成绩");
                    for (Student student : stu) {
                        System.out.println(student);
                    }
                } else if (x == 2) {
                    AverageCompare an = new AverageCompare();
                    Collections.sort(stu, an);// 按平均成绩从高到低排序
                    // 清空文件
                    Fclose(s1);
                    // 文件写入
                    FileOutputStream fos = new FileOutputStream(s1, true);
                    byte[] byts = "学号      \t姓名  \t数学成绩\t英语成绩\tJava成绩\t总分成绩\t平均成绩".getBytes();
                    fos.write(byts);
                    byte[] bytes = "\r\n".getBytes();
                    fos.write(bytes);
                    for (Student a : stu) {
                        String line = a.toString();
                        byte[] byts1 = line.getBytes();
                        fos.write(byts1);
                        byte[] bytes1 = "\r\n".getBytes();
                        fos.write(bytes1);
                    }
                    fos.close();
                    System.out.println("学号      \t姓名  \t数学成绩\t英语成绩\tJava成绩\t总分成绩\t平均成绩");
                    for (Student s : stu) {
                        System.out.println(s);
                    }
                } else {
                    System.out.println("输入错误。");
                }
                System.out.println("是否继续查询，输入yes/no");
                String s = sc.nextLine().trim();
                if (s.equals("yes"))
                    ;
                else if (s.equals("no")) {
                    System.out.println("查询功能已退出。");
                    return;
                } else {
                    System.out.println("输入错误，已自动退出查询功能");
                    return;
                }
            }

        }
    }

    public static void passStudent(ArrayList<Student> stu, ArrayList<Just> stujust) throws IOException {
        JustCompare an = new JustCompare();
        Collections.sort(stujust, an);
        int cnt1 = 0;
        int cnt2 = 0;
        Fclose(s2);// 文件清空
        System.out.println("学号      \t姓名  \t及格情况");
        FileOutputStream fos = new FileOutputStream(s2, true);
        byte[] byts = "学号      \t姓名  \t及格情况".getBytes();
        fos.write(byts);
        byte[] bytes = "\r\n".getBytes();
        fos.write(bytes);
        for (Just a : stujust) {
            if(a.getHg().equals("pass")) cnt1++;
            else cnt2 ++;
            String line = a.toString();
            byte[] byts1 = line.getBytes();
            fos.write(byts1);
            byte[] bytes1 = "\r\n".getBytes();
            fos.write(bytes1);
            System.out.println(a);
        }
        String passout = "及格人数有："+cnt1+"，不及格人数有："+cnt2;
        byte[] bytes2 = passout.getBytes();
        fos.write(bytes2);
        fos.close();
        System.out.println(passout);
        System.out.println("输入no退出该功能");
        if (sc.nextLine().trim().equals("no"))
            ;
        else {
            System.out.println("输入无法识别，已自动退出该功能");
        }
    }

    public static void query1Student(ArrayList<Student> stu, ArrayList<Just> stujust) {
        // 遍历集合并处理数据
        System.out.println("输入你的学号：");
        String id = sc.nextLine().trim();
        int index = IDCX(stu, id);
        if (index == -1) {
            System.out.println("学号不存在");
        } else {
            System.out.println("学号      \t姓名  \t数学成绩\t英语成绩\tJava成绩\t总分成绩\t平均成绩\t及格情况");
            Student s = stu.get(index);
            System.out.println(s.toString() + "\t" + stujust.get(index).getHg());
        }
    }

    public static int IDCX(ArrayList<Student> stu, String id) {
        // 遍历集合并查找输入的id
        for (int i = 0; i < stu.size(); i++) {
            Student s = stu.get(i);// 定义一个Student的类的变量并赋值
            String sid = s.getStuid();// 抽出该索引所指的id
            if (sid.equals(id)) {
                return i;// 找到后返回索引
            }
        }
        // 没有找到就返回-1
        return -1;
    }

    public static int IDCX2(ArrayList<Just> stu, String id) {
        // 遍历集合并查找输入的id
        for (int i = 0; i < stu.size(); i++) {
            Student s = stu.get(i);// 定义一个Student的类的变量并赋值
            String sid = s.getStuid();// 抽出该索引所指的id
            if (sid.equals(id)) {
                return i;// 找到后返回索引
            }
        }
        // 没有找到就返回-1
        return -1;
    }

    public static void Fclose(String s) {
        final File file = new File(s);
        try {
            // 使用FileWriter不需要考虑原文件不存在的情况
            // 当该文件不存在时，new FileWriter(file)会自动创建一个真实存在的空文件
            FileWriter fileWriter = new FileWriter(file);
            // 往文件重写内容
            fileWriter.write("");// 清空
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Fbc(ArrayList<Student> stu) throws IOException {
        Fclose(s1);// 文件
        FileOutputStream fos = new FileOutputStream(s1, true);
        byte[] byts = "学号      \t姓名  \t数学成绩\t英语成绩\tJava成绩\t总分成绩\t平均成绩".getBytes();
        fos.write(byts);
        byte[] bytes = "\r\n".getBytes();
        fos.write(bytes);
        for (Student a : stu) {
            String line = a.toString();
            byte[] byts1 = line.getBytes();
            fos.write(byts1);
            byte[] bytes1 = "\r\n".getBytes();
            fos.write(bytes1);
        }
        fos.close();
    }

    public static void Fcopy(String a1, String a2) throws IOException {
        FileInputStream fis1 = new FileInputStream(a1);
        FileOutputStream fos1 = new FileOutputStream(a2);
        int b;
        while ((b = fis1.read()) != -1) {
            fos1.write(b);
        }
        fos1.close();
        fis1.close();
    }

    public static void Fimport(ArrayList<Student> stu, ArrayList<Just> stujust) throws IOException {
        Fcopy("a.txt", s1);
        try (Scanner scanner = new Scanner(new File(s1))) {// 文件路径
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\s+");
                if (!data[0].equals("学号")) {
                    String id = data[0];
                    String name = data[1];
                    double Mathscore = Double.parseDouble(data[2]);
                    double Englishscore = Double.parseDouble(data[3]);
                    double Javascore = Double.parseDouble(data[4]);
                    Student a = new Student(id, name, Mathscore, Englishscore, Javascore);
                    Just aaa = new Just(id, name, Mathscore, Englishscore, Javascore);
                    stu.add(a); // 将每行数据添加到父类集合中
                    // 将每行数据添加到子类集合中
                    stujust.add(aaa);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在: " + e.getMessage());
        }
    }
}