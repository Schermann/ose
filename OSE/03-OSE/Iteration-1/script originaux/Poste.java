import java.util.ArrayList ;

public class Poste {
	private ArrayList<Poste> postesVisibles ;
	private Position position ;
	private int orientation ;
	
	public Poste(Position position, int orientation) {
		super() ;
		this.position = position ;
		this.orientation = orientation ;
		this.initialiserPostesVisibles() ;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
	public String toString(){
		return position + " : " + orientation + " : " + this.peutVoir() ;
	}
	
	public int getTravee(){
		return this.position.getTravee() ;
	}
	
	public int getRangee(){
		return this.position.getRangee() ;
	}
	
	public boolean peutVoir(){
		if(this.postesVisibles.size() == 0){
			return false ;
		}
		else {
			return true ;
		}
	}
	
	public void initialiserPostesVisibles(){
		this.postesVisibles = new ArrayList<Poste>() ;
	}
	
	public void ajouterPosteVisible(Poste poste){
		this.postesVisibles.add(poste) ;
	}
	
	public ArrayList<Poste> getPostesVisibles(){
		return this.postesVisibles ;
	}
	
	public int nbPostesVisibles(){
		return this.postesVisibles.size() ;
	}
}
