package Exam_Advande_1.ra.bussinessImpl;

import Exam_Advande_1.ra.bussiness.IShop;
import Exam_Advande_1.ra.run.BookManagement;

import java.util.List;
import java.util.Scanner;

public class Book implements IShop, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sách");
        this.bookId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sách");
        this.bookName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sách");
        this.title = scanner.nextLine();
        System.out.println("Nhập số trang sách");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());
        this.author = inputAuthor(BookManagement.authorList, scanner);
        System.out.println("Nhập giá nhập sách");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        this.exportPrice = getImportPrice() * RATE;
        System.out.println("Nhập số lượng sách");
        this.quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập trạng thái sách (true/false)");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());

    }

    public Author inputAuthor(List<Author> authorList, Scanner scanner) {
        if (authorList.isEmpty()) {
            System.out.println("Danh sách tác giả trống");
            return null;
        }
        System.out.println("Danh sách tác giả");
        for (int i = 0; i < authorList.size(); i++) {
            System.out.printf("| STT : %d | Tên : %s |\n", (i + 1), authorList.get(i).getAuthorName());
        }
        System.out.println("Nhập số thứ tự của tác giả bạn muốn chọn");
        int numberOfAuthor = Integer.parseInt(scanner.nextLine());
        return authorList.get(numberOfAuthor - 1);
    }

    @Override
    public void displayData() {
        System.out.printf("| Mã sách : %d | Tên sách : %s | Tên tác giả : %s | Giá bán sách : %f | Số lượng sách : %d | Trạng thái : %s |\n", bookId, bookName, author.getAuthorName(), exportPrice, quantity, bookStatus ? "Bán" : "Ngưng bán");

    }

    @Override
    public int compareTo(Book o) { // sắp xếp theo giá xuất sách
        return (int) (this.exportPrice - o.exportPrice);
    }
}
