import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class FormRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student> studentList = new ArrayList();
        Enumeration e = request.getParameterNames();

        PrintWriter out = response.getWriter();
        while (e.hasMoreElements()) {
            for(int i=0;i<5;i++){
                Student student = new Student();
                String surname = (String) e.nextElement();
                String surnameValue = request.getParameter(surname);
                student.setSurname(surnameValue);
                String name = (String) e.nextElement();
                String nameValue = request.getParameter(name);
                student.setName(nameValue);
                String mark = (String) e.nextElement();
                String markValue = request.getParameter(mark);
                student.setMark(markValue);
                String course = (String) e.nextElement();
                String courseValue = request.getParameter(course);
                student.setCourse(courseValue);
                studentList.add(student);
            }
            for(Student st : studentList) {
                out.println(st.surname + st.name + st.mark + st.course + "-----");
            }
            //Student [] result = studentList.toArray(new Student[studentList.size()]);
            //out.println(Arrays.toString(result));
                String name = (String) e.nextElement();
                String value = request.getParameter("sort");
                switch (value) {
                    case "1":
                        sortSurname(studentList);
                        break;
                    case "2":
                        sortMark(studentList);
                        break;
                    case "3":
                        sortCourse(studentList);
                        break;
                    default:
                        out.println("<h2>YOU DIDN'T CHOOSE THE WAY OF SORTNG</h2>");
                }
            //for(Student st : studentList) {
            //    out.println(st.surname + st.name + st.mark + st.course + "-----");
            //}
                //Student [] result = studentList.toArray(new Student[studentList.size()]);
                //System.out.println(Arrays.toString(result));
                //out.println(studentList);
                }
        System.out.println(studentList.size());

            }


    List<Student> sortSurname(List <Student> students){
        return students.stream()
                .sorted(Comparator.comparing(Student::getSurname))
                .collect(Collectors.<Student>toList());
    }

            void sortMark(List <Student> students ) {
                students.stream()
                        .sorted(Comparator.comparing(Student::getMark))
                        .collect(Collectors.<Student>toList());
            }

            void sortCourse(List <Student> students) {
                students.stream()
                        .sorted(Comparator.comparing(Student::getCourse))
                        .collect(Collectors.<Student>toList());
            }
        }

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Hello</title></head>");
        out.println("<body><h1>HHH</h1></body>");
        out.println("<html>");
    }*/
