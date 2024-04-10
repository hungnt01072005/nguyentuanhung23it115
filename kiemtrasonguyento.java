package nguyentuanhung23it115;

public class kiemtrasonguyento {
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;

	public class Main {

	    public static void main(String[] args) {
	        ExecutorService executorService = Executors.newFixedThreadPool(3);

	        // Tạo các Thread
	        Thread thread1 = new Thread(new StudentAgeThread("Nguyễn Văn A", "2000-01-01"));
	        Thread thread2 = new Thread(new StudentAgeEnhancedThread("Nguyễn Văn B", "2001-02-02"));
	        Thread thread3 = new Thread(new StudentAgePrimeThread("Nguyễn Văn C", "2002-03-03"));

	        // Gửi các Thread đến ExecutorService
	        executorService.submit(thread1);
	        executorService.submit(thread2);
	        executorService.submit(thread3);

	        // Shutdown ExecutorService sau khi tất cả các Thread hoàn thành
	        executorService.shutdown();
	    }
	}

	public class StudentAgePrimeThread implements Runnable {

	    private String studentName;
	    private String dateOfBirth;

	    public StudentAgePrimeThread(String studentName, String dateOfBirth) {
	        this.studentName = studentName;
	        this.dateOfBirth = dateOfBirth;
	    }

	    @Override
	    public void run() {
	        // Tính tổng các chữ số trong ngày tháng năm sinh
	        int sum = 0;
	        for (char c : dateOfBirth.toCharArray()) {
	            if (Character.isDigit(c)) {
	                sum += Character.getNumericValue(c);
	            }
	        }

	        // Kiểm tra số nguyên tố
	        boolean isPrime = true;
	        if (sum <= 1) {
	            isPrime = false;
	        } else {
	            for (int i = 2; i <= Math.sqrt(sum); i++) {
	                if (sum % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	        }

	        // In thông tin
	        System.out.println("Tên sinh viên: " + studentName);
	        System.out.println("Tổng các chữ số trong ngày tháng năm sinh: " + sum);
	        System.out.println("Là số nguyên tố: " + isPrime);
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        // Tạo Thread mới
	        Thread thread = new Thread(new StudentAgePrimeThread("Nguyễn Văn B", "2001-02-02"));

	        // Khởi chạy Thread
	        thread.start();
	    }
}
