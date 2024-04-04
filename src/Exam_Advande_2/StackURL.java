package Exam_Advande_2;

import java.util.Scanner;
import java.util.Stack;

public class StackURL {
    public static void main(String[] args) {
        StackURL stackURL = new StackURL();
        Stack<String> stringStack = new Stack<>(); //tạo cấu trúc dữ liệu stack
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập URL muốn truy cập\n" +
                    "2. Quay lại\n" +
                    "3. Thoát");
            System.out.println("Nhập lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1://Chọn 1 thực hiện nhập một chuỗi từ bàn phím và lưu vào stack.
                    stackURL.inputURL(scanner, stringStack);
                    break;
                case 2://Chọn 2 thực hiện xóa URL trên cùng của stack và in ra URL tiếp theo
                    stackURL.removeURL(stringStack);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập lựa chọn từ 1 dến 3");
            }
        } while (true);
    }

    //thực hiện nhập một chuỗi từ bàn phím và lưu vào stack.
    public void inputURL(Scanner scanner, Stack<String> stringStack) {
        System.out.println("Nhập URL :");
        String urlInput = scanner.nextLine();
        stringStack.push(urlInput);
    }

    //thực hiện xóa URL trên cùng của stack và in ra URL tiếp theo
    public void removeURL(Stack<String> stringStack) {
        if (stringStack.isEmpty()) { // mục lưu trống
            System.out.println("Không còn URL tiếp theo");
        } else {
            stringStack.pop();
            System.out.println("URL tiếp theo " + stringStack.peek());
        }
    }
}
