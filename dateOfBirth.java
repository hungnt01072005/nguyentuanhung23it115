package nguyentuanhung23it115;

public class dateOfBirth {
	import java.time.LocalDate;
	import java.time.Period;

	public class StudentAgeThread implements Runnable {

	    private String studentName;
	    private String dateOfBirth;

	    public StudentAgeThread(String studentName, String dateOfBirth) {
	        this.studentName = studentName;
	        this.dateOfBirth = dateOfBirth;
	    }

	    @Override
	    public void run() {
	        // Tính tuổi sinh viên
	        LocalDate dob = LocalDate.parse(dateOfBirth);
	        LocalDate today = LocalDate.now();
	        Period period = Period.between(dob, today);

	        int years = period.getYears();
	        int months = period.getMonths();
	        int days = period.getDays();

	        // Mã hóa chữ số
	        String encodedAge = "";
	        for (char c : String.valueOf(years).toCharArray()) {
	            encodedAge += (char) (c + 3);
	        }
	        for (char c : String.valueOf(months).toCharArray()) {
	            encodedAge += (char) (c + 2);
	        }
	        for (char c : String.valueOf(days).toCharArray()) {
	            encodedAge += (char) (c + 1);
	        }

	        // In thông tin
	        System.out.println("Tên sinh viên: " + studentName);
	        System.out.println("Tuổi: " + years + " năm " + months + " tháng " + days + " ngày");
	        System.out.println("Mã hóa chữ số: " + encodedAge);
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        // Tạo Thread mới
	        Thread thread = new Thread(new StudentAgeThread("Nguyễn Văn A", "2000-01-01"));

	        // Khởi chạy Thread
	        thread.start();
	    }
	}

