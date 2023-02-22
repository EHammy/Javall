package model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class ListStudent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="Student")
	private String Student;
	@Column(name="Attendance")
	private String Attendance;
	
	public ListStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListStudent(String Student, String Attendance) {
		super();
		this.Student = Student;
		this.Attendance = Attendance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent() {
		return Student;
	}

	public void setStudent(String student) {
		this.Student = student;
	}

	public String getAttendance() {
		return Student;
	}

	public void setAttendance(String Attendance) {
		this.Attendance = Attendance;
	}
	public String returnStudentDetails( ) {
		return Student + ": " + Attendance;
	}

}
