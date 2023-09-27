package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    static Book[] arrBook = new Book[100];
    static int currentIndex = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách)");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách ");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống
            switch (choice) {
                case 1:
                    BookManagement.createProduct();

                    break;
                case 2:
                    for (int i = 0; i < currentIndex; i++) {
                        arrBook[i].display();
                    }
                    break;
                case 3:
                    for (int i = 0; i < currentIndex; i++) {
                        arrBook[i].calProfit();

                    }
                    break;

                case 4:
                        deleteBook();

                    break;
                case 5:
                    search();

                    break;
                case 6:

                    break;

                case 7:
                    System.out.println("Thoát!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);
    }



    public static void createProduct() {
        System.out.println("Nhập vào số sản phẩm");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrBook[i] = new Book();
            arrBook[i].inputData(scanner, arrBook, currentIndex);
            currentIndex++;
        }


    }
    public static void sortPriceBook() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrBook[j].getInterest() > arrBook[i].getInterest()) {
                    Book temp = arrBook[j];
                    arrBook[j] = arrBook[i];
                    arrBook[i] = temp;
                }
            }

        }
    }
    public static void deleteBook(){
        System.out.println("Nhập mã sách cần xoá");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < currentIndex; i++) {
            if(arrBook[i].getBookId() == deleteId){
                index = i;
                break;
            }
        }
        if(index == -1 ){
            System.out.println("Mã sách không tìm thấy");
        }else {
            for (int i = 0; i < currentIndex; i++) {
                for (int j = deleteId; j < currentIndex - 1; j++) {
                    arrBook[j] = arrBook[j + 1];
                }
            }

        }
    }


    public static void search(){
        System.out.println("Nhập từ cần tìm kiếm");
        String searchName = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if(arrBook[i].getBookName().toLowerCase().contains(searchName.toLowerCase()) || arrBook[i].getDescriptions().toLowerCase().contains(searchName.toLowerCase())){
                arrBook[i].display();

            }
        }

    }


}




