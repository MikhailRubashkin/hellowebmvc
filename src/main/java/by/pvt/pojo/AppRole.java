package by.pvt.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RoleName roleName;

    public AppRole ( RoleName roleName ){
        this.roleName = roleName;
    }

    public AppRole (){

    }

    public Long getId (){
        return id;
    }

    public void setId ( Long id ){
        this.id = id;
    }

    public RoleName getRoleName (){
        return roleName;
    }

    public void setRoleName ( RoleName roleName ){
        this.roleName = roleName;
    }

    @Override
    public boolean equals ( Object o ){
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;

        AppRole appRole = (AppRole) o;

        if (id != null ? !id.equals (appRole.id) : appRole.id != null) return false;
        return roleName == appRole.roleName;
    }

    @Override
    public int hashCode (){
        int result = id != null ? id.hashCode ( ) : 0;
        result = 31 * result+(roleName != null ? roleName.hashCode ( ) : 0);
        return result;
    }

    @Override
    public String toString (){
        return "AppRole{"+
               "id="+id+
               ", roleName="+roleName+
               '}';
    }
}

