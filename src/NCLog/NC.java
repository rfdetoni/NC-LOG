package NCLog;

public class NC {
    public int id_nc;
    private int id_criador, id_plano;
    private String nome, descricao, local, responsavel;
    
    public void criarNC(){
    
    }
    
    public void editarNC(){
    }
    public void apagarNC(){
    
    }
    
    public void criarPlano(){
        PlanoDeAcao p = new PlanoDeAcao();
        p.criarPlano(local, responsavel, descricao);
    
    }
    
    
    
}
