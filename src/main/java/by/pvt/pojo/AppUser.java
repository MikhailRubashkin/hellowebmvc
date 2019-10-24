package by.pvt.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany
    private Set<AppRole> appRoles;

    public AppUser(){}

    public AppUser ( String firstName, String lastName, String email, String password, Set<AppRole> appRoles ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appRoles = appRoles;
    }

    public Long getId (){
        return id;
    }

    public void setId ( Long id ){
        this.id = id;
    }

    public String getFirstName (){
        return firstName;
    }

    public void setFirstName ( String firstName ){
        this.firstName = firstName;
    }

    public String getLastName (){
        return lastName;
    }

    public void setLastName ( String lastName ){
        this.lastName = lastName;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail ( String email ){
        this.email = email;
    }

    public String getPassword (){
        return password;
    }

    public void setPassword ( String password ){
        this.password = password;
    }

    public Set<AppRole> getAppRoles (){
        return appRoles;
    }

    public void setAppRoles ( Set<AppRole> appRoles ){
        this.appRoles = appRoles;
    }

    @Override
    public boolean equals ( Object o ){
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;

        AppUser appUser = (AppUser) o;

        if (id != null ? !id.equals (appUser.id) : appUser.id != null) return false;
        if (firstName != null ? !firstName.equals (appUser.firstName) : appUser.firstName != null) return false;
        if (lastName != null ? !lastName.equals (appUser.lastName) : appUser.lastName != null) return false;
        if (email != null ? !email.equals (appUser.email) : appUser.email != null) return false;
        if (password != null ? !password.equals (appUser.password) : appUser.password != null) return false;
        return appRoles != null ? appRoles.equals (appUser.appRoles) : appUser.appRoles == null;
    }

    @Override
    public int hashCode (){
        int result = id != null ? id.hashCode ( ) : 0;
        result = 31 * result+(firstName != null ? firstName.hashCode ( ) : 0);
        result = 31 * result+(lastName != null ? lastName.hashCode ( ) : 0);
        result = 31 * result+(email != null ? email.hashCode ( ) : 0);
        result = 31 * result+(password != null ? password.hashCode ( ) : 0);
        result = 31 * result+(appRoles != null ? appRoles.hashCode ( ) : 0);
        return result;
    }

    @Override
    public String toString (){
        return "AppUser{"+
               "id="+id+
               ", firstName='"+firstName+'\''+
               ", lastName='"+lastName+'\''+
               ", email='"+email+'\''+
               ", password='"+password+'\''+
               ", appRoles="+appRoles+
               '}';
    }
}
