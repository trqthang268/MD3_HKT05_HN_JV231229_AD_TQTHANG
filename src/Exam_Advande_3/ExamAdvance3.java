package Exam_Advande_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ExamAdvance3 {
    public static void main(String[] args) {
        ExamAdvance3 examAdvance = new ExamAdvance3();
        Scanner scanner = new Scanner(System.in);
        Queue<String> clientName = new LinkedList<>(); //Queue Interface và LinkedList Class để lưu lại danh sách
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên khách hàng chờ mua vé xem phim\n" +
                    "2. Khách tiếp theo\n" +
                    "3. Thoát");
            System.out.println("Nhập lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    examAdvance.inputClient(scanner, clientName);
                    break;
                case 2:
                    examAdvance.nextClient(clientName);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập lựa chọn từ 1 đến 3");
            }
        }
    }

    //thực hiện nhập một chuỗi từ bàn phím và lưu vào queue
    public void inputClient(Scanner scanner, Queue<String> clientName) {
        System.out.println("Nhập tên khách hàng chờ mới");
        String newClient = scanner.nextLine();
        clientName.add(newClient);
    }

    //thực hiện in phần tử đầu tiên và xóa phần tử đầu tiên
    public void nextClient(Queue<String> clientName) {
        if (clientName.isEmpty()) { //nếu danh sách chờ trống
            System.out.println("Không có khách chờ");
            System.out.println("------------------");
        } else {
            System.out.println("Khách hàng tiếp theo là :" + clientName.poll());
            System.out.println("--------------------");
        }
    }
}
