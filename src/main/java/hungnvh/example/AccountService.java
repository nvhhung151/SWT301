package hungnvh.example;
public class AccountService {

    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.length() <= 6) return false;
        if (!isValidEmail(email)) return false;
        return true;
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        // Kiểm tra bắt buộc phải có @ và tên miền sau dấu chấm
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

}

