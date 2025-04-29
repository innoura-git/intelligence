package com.innoura.Intelligence.Entity;

/**import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

*/
public class ServiceDetails
{
    ///@Id
    ///@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private String userName;
    private String serviceName;

    public ServiceDetails()
    {
    }

    @Override
    public String toString()
    {
        return "ServiceDetails{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }

    public ServiceDetails(int id, String url, String userName, String serviceName)
    {
        this.id = id;
        this.url = url;
        this.userName = userName;
        this.serviceName = serviceName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }
}

