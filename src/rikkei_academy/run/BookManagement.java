package rikkei_academy.run;

import rikkei_academy.businessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        List<Book> listBooks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("****************BOOK-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách.\n" +
                    "2. Hiển thị thông tin các sách.\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần.\n" +
                    "4. Xóa sách theo mã sách.\n" +
                    "5. Tìm kiếm sách theo tên sách.\n" +
                    "6. Thay đổi trạng thái của sách theo mã sách.\n" +
                    "7. Thoát");
            System.out.println("Nhập để chọn chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    createBook(listBooks,scanner);
                    break;
                    case 2:
                        displayListBooks(listBooks);
                    break;
                    case 3:
                        sortByInterest(listBooks);
                    break;
                    case 4:
                        deleteBooks(listBooks,scanner);
                    break;
                    case 5:
                        searchBook(listBooks,scanner);
                    break;
                    case 6:
                        changeStatus(listBooks,scanner);
                    break;
                    case 7:
                        System.exit(0);
                    break;
                default:
                    System.out.println("Nhập không chính xác");
            }
        }
    }
    public static void createBook(List<Book> list,Scanner scanner){
        System.out.println("Nhập số sách cần nhập :");
        int numb = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numb; i++) {
            System.out.println("Nhập thông tin cuốn số : " + (i + 1));
            Book book = new Book();
            book.inputData(scanner);
            if (list.size() == 0){
                book.setBookId(1);
            } else {
                book.setBookId(list.get(list.size() - 1).getBookId() + 1);
            }
            list.add(book);
        }
    }
    public static void displayListBooks(List<Book> list){
        for (Book book:list) {
            book.displayData();
        }
    }
    public static void sortByInterest(List<Book> list){
        List<Book> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        Collections.sort(newList);
        displayListBooks(list);
        displayListBooks(newList);
    }
    public static void deleteBooks(List<Book> list,Scanner scanner){
        Book book = new Book();
        displayListBooks(list);
        System.out.println("Nhập mã sách cần xóa");
        int idDel = Integer.parseInt(scanner.nextLine());
        list.remove(idDel - 1);
    }
    public static void searchBook(List<Book> list,Scanner scanner){
        List<Book> listSearch = new ArrayList<>();
        System.out.println("Nhập tên sách cần tìm kiếm");
        String searchName = scanner.nextLine();
        for (Book book: list) {
            if (book.getBookName().contains(searchName)){
                listSearch.add(book);
            }
        }
        displayListBooks(listSearch);
    }
    public static void changeStatus(List<Book> list,Scanner scanner){
        displayListBooks(list);
        System.out.println("Nhập mã sách cần thay đổi trạng thái");
        int idChange = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập trạng thái thay đổi");
        boolean newStatus = Boolean.parseBoolean(scanner.nextLine());
        list.get(idChange - 1).setBooksStatus(newStatus);
    }
}
