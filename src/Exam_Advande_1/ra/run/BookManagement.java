package Exam_Advande_1.ra.run;

import Exam_Advande_1.ra.bussinessImpl.Author;
import Exam_Advande_1.ra.bussinessImpl.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static List<Book> bookList = new ArrayList<>();
    public static List<Author> authorList = new ArrayList<>();

    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả \n" +
                    "2. Nhập số sách và nhập thông tin các sách \n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách \n" +
                    "5. Thoát ");
            System.out.println("Nhập lựa chọn của bán");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookManagement.inputAuthor(scanner, authorList);
                    break;
                case 2:
                    bookManagement.inputBook(scanner, bookList);
                    break;
                case 3:
                    bookManagement.sortBookByExportPrice(bookList);
                    break;
                case 4:
                    bookManagement.searchBookByAuthorName(bookList, scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhập lựa chọn từ 1 đến 5");
            }
        } while (true);
    }

    //Nhập số tác giả và nhập thông tin các tác giả
    public void inputAuthor(Scanner scanner, List<Author> authorList) {
        System.out.println("Nhập số tác giả ");
        int numberOfAuthor = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfAuthor; i++) {
            System.out.println("Nhập thông tin cho tác giả thứ " + (i + 1));
            Author newAuthor = new Author(); // tạo tác giả mới
            newAuthor.inputData();           // nhập thông tin cho tác giả mới
            authorList.add(newAuthor);       // thêm tác giả mới vào list
        }
        System.out.println("Nhập hoàn tất");
    }

    //Nhập số sách và nhập thông tin các sách
    public void inputBook(Scanner scanner, List<Book> bookList) {
        System.out.println("Nhập số sách ");
        int numberOfBook = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfBook; i++) {
            System.out.println("Nhập thông tin cho sách thứ " + (i + 1));
            Book newBook = new Book();     //tạo sách mới
            newBook.inputData();           //nhập thông tin sách
            bookList.add(newBook);         //thêm sách vào list
        }
        System.out.println("Nhập hoàn tất");
    }

    //Sắp xếp sách theo giá xuất sách tăng dần (sử dụng Comparable)
    public void sortBookByExportPrice(List<Book> bookList) {
        if (bookList.isEmpty()) {
            System.out.println("Danh sách sách trống, vui lòng thêm sách trước");
        } else {
            System.out.println("Danh sách trước khi sắp xếp");
            bookList.forEach(Book::displayData);        //dùng forEach duyệt qua và in toàn bộ sách có trong list
            System.out.println("Danh sách sau khi sắp xếp");
            Collections.sort(bookList);
            bookList.forEach(Book::displayData);
        }
    }

    //Tìm kiếm sách theo tên tác giả sách
    public void searchBookByAuthorName(List<Book> bookList, Scanner scanner) {
        System.out.println("Nhập tên tác giả");
        String searchAuthorName = scanner.nextLine();
        // check tồn tại của tác giả trong book
        boolean isExist = bookList.stream().anyMatch(book -> book.getAuthor().getAuthorName().equalsIgnoreCase(searchAuthorName));
        if (isExist) {
            System.out.println("Danh sách sách có tên tác giả cần tìm là"); // dùng filter để lọc những sách có trùng tên tác giả sách
            bookList.stream().filter(book -> book.getAuthor().getAuthorName().equalsIgnoreCase(searchAuthorName)).forEach(Book::displayData);
        } else {
            System.out.println("Không tim thấy sách theo tên tác giả này");
        }
    }
}
