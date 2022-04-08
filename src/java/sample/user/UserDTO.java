
package sample.user;

public class UserDTO {
    private String userID;
    private String fullName;
    private String RoleID;
    private String password;
    private String phone;
    private String address;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String RoleID, String password) {
        this.userID = userID;
        this.fullName = fullName;
        this.RoleID = RoleID;
        this.password = password;
    }

    public UserDTO(String userID, String fullName, String RoleID, String password, String phone, String address) {
        this.userID = userID;
        this.fullName = fullName;
        this.RoleID = RoleID;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
    
   public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
