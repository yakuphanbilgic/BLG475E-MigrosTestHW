package configs;

public class InternalProps extends AbstractProps
{
    private String phoneNumber;
    private String password;


    public InternalProps()
    {
        loadConfigProperties("internal_config.properties");

        this.phoneNumber = configProps.getProperty("user.phoneNumber");
        this.password = configProps.getProperty("user.password");
    }

    //Getters and Setters


    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
