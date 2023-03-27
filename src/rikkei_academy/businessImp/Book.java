package rikkei_academy.businessImp;

import rikkei_academy.business.IBook;

import java.util.Scanner;

public class Book implements IBook,Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean booksStatus;

    public Book() {
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

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBooksStatus() {
        return booksStatus;
    }

    public void setBooksStatus(boolean booksStatus) {
        this.booksStatus = booksStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên sách :");
        this.bookName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sách :");
        this.title = scanner.nextLine();
        System.out.println("Nhập số trang sách :");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá nhập sách :");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá bán sách :");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái sách :");
        this.booksStatus = Boolean.parseBoolean(scanner.nextLine());
        this.interest = exportPrice - importPrice;
    }

    @Override
    public void displayData() {
        System.out.println("------------------------------------------------------");
        System.out.printf("Mã sách : %d \n",bookId);
        System.out.printf("Tên sách : %s \n",bookName);
        System.out.printf("Tiêu đề sách : %s \n",title);
        System.out.printf("Số trang sách : %d \n",numberOfPages);
        System.out.printf("Giá nhập sách : %.1f \n",importPrice);
        System.out.printf("Giá bán sách : %.1f \n",exportPrice);
        System.out.printf("Lợi nhuận sách : %.1f \n",interest);
        System.out.println("Trạng thái sách : %s \n" + (booksStatus?"còn bán":"hết sách"));
        System.out.println("------------------------------------------------------");
    }

    @Override
    public int compareTo(Book o) {
        return (int) (o.getInterest() - this.interest);
    }
}
