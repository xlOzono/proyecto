package Persona;

public class Juridica extends Persona {
    private String razonSocial;
    private int rolTributario;
    
    public Juridica(String email, int telefono, String direccion, String razonSocial, int rolTributario) {
        super(email, telefono, direccion);
        this.razonSocial = razonSocial;
        this.rolTributario = rolTributario;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getRolTributario() {
        return rolTributario;
    }

    public void setRolTributario(int rolTributario) {
        this.rolTributario = rolTributario;
    }

    
}
