package hu.bme.aut.afk.thefutureofanonymus.webshop.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	/*public static final String  ROLE_ADMIN = "ROLE_ADMIN";
	public static final String  ROLE_USER = "ROLE_USER";*/

	@Id
	@GeneratedValue
	private String name;
	private String password;
	//private boolean enabled; //TODO: miez?
	private UserRoles role;


	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//public boolean isEnabled() { return enabled; }


	//public void setEnabled(boolean enabled) {this.enabled = enabled;}

	//public List<String> getRoles() {return roles;}

	public UserRoles getRole() { return role; }

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
