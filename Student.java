package nguyentuanhung23it115;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class ReadStudentXML {

	        public static void main(String[] args) throws Exception {
	            // Tạo DocumentBuilderFactory
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	            // Tạo DocumentBuilder
	            DocumentBuilder builder = factory.newDocumentBuilder();

	            // Đọc file XML
	            Document document = builder.parse("student.xml");

	            // Lấy danh sách element "student"
	            NodeList studentList = document.getElementsByTagName("student");

	            // Duyệt qua danh sách student
	            for (int i = 0; i < studentList.getLength(); i++) {
	                Element studentElement = (Element) studentList.item(i);

	                // Lấy thông tin sinh viên
	                int id = Integer.parseInt(studentElement.getElementsByTagName("id").item(0).getTextContent());
	                String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
	                String address = studentElement.getElementsByTagName("address").item(0).getTextContent();
	                String dateOfBirth = studentElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();

	                // In thông tin sinh viên
	                System.out.println("ID: " + id);
	                System.out.println("Name: " + name);
	                System.out.println("Address: " + address);
	                System.out.println("Date of Birth: " + dateOfBirth);
	                System.out.println();
	            }
	        }
	    }