/**
 * Andrew Stiers
 *
 * 04/26/23
 *
 * Class to deal with the user login information.
 */

package data.account;

public class AccountInfo {

    private int accountId;

    private String username;

    private String password;

    private String emailAddress;

    private String firstLast;


    //Constructor to check account information
    public AccountInfo(String username, String emailAddress, String password)
    {
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;

    }

    //Constructor to build accounts
    public AccountInfo(String username, String emailAddress, String password,
                       String firstLast)
    {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.firstLast = firstLast;
    }

    public int getAccountId()
    {
        return accountId;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getFirstLast() {return firstLast; }

    public void setUsername(String newUserName)
    {
        this.username = newUserName;
    }

    public void setEmailAddress(String newEmailAddress) {
        this.emailAddress = newEmailAddress;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setFirstLast(String newFirstLast)
    {
        this.firstLast = newFirstLast;
    }
}
