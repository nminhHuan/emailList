package murach.data;

import murach.business.User;

public class UserDB {

    public static long insert(User user) {
        System.out.println("Đã lưu người dùng vào Database thành công:");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
        return 1;
    }
}