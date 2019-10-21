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
}

