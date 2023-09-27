package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;

    private String bookName;

    private String author;
    private String descriptions;

    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;
    private  static int nextId = 0;
    public Book() {

    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {

        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner, Book[] arrBook, int curentIndex) {
        boolean isExit = false;
        do {

            do {
                System.out.println("Nhập  vào Id");
                this.bookId = Integer.parseInt(scanner.nextLine());

                break;

            } while (true);


            do {
                System.out.println("Nhập vào tên sách: tên sách không được để trống");
                this.bookName = scanner.nextLine();
                if (!this.bookName.isEmpty()) {
                    break;
                } else {
                    System.out.println("Tên sách không  để  trống");
                }

            } while (true);

            do {
                System.out.println("Nhập vào tên tác giả: tên tác giả không được để trống");
                this.author = scanner.nextLine();
                if (!this.author.isEmpty()) {
                    break;
                } else {
                    System.out.println("Tên tác giả để trống");
                }

            } while (true);

            do {
                System.out.println("Nhập vào mô tả: Mô tả không được đẻ trống");
                this.descriptions = scanner.nextLine();
                if (!this.descriptions.isEmpty()) {
                    if( descriptions.length() > 10){
                        break;
                    } else {
                        System.out.println("Mô tả phải lớn hơn 10 kí tự");
                    }
                    break;
                } else {
                    System.out.println("Mô tả không đẻ trống");
                }
            }
            while (true);

            do {
                System.out.println("Nhập vào giá nhập: Giá nhập phải lớn hơn 0");
                this.importPrice = Double.parseDouble(scanner.nextLine());
                if (this.importPrice > 0){
                    break;
                } else {
                    System.out.println("giá nhập phải lon hơn 0)");
                }
            } while (true);


            do {
                System.out.println("Nhập vào giá Bán:");
                this.exportPrice = Double.parseDouble(scanner.nextLine());
                if (exportPrice > importPrice*1.2){
                    break;
                } else {
                    System.out.println("giá bán phải lớn hơn 1.2 lần gia nhập");
                }

            }
            while (true);
            System.out.println("nhập vào trạng thái: trạng thái nhập vào là true, và false:");
            this.bookStatus = Boolean.parseBoolean(scanner.nextLine());
            break;
        } while (!isExit);

    }
    public void calProfit(){
       this.interest = (float) (getExportPrice() - getImportPrice());
        System.out.println("Lợi nhuận" + this.interest );
    }

    public void display(){
        System.out.println("________THÔNG TIN SÁCH________");
        System.out.println("Id sách:" + this.bookId);
        System.out.println("Tên sách:" + this.bookName);
        System.out.println("Tác giả:" + this.author);
        System.out.println("Mô tả:" + this.descriptions);
        System.out.println("Giá Nhập:" + this.importPrice);
        System.out.println("Giá bán:" + this.exportPrice);
        System.out.println("Lợi nhuận" + this.interest);
        System.out.println("Trạng thái" + this.bookStatus);

    }


}
