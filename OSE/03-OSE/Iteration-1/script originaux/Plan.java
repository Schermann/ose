
import java.awt.* ;
import javax.swing.* ;

public class Plan extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private PlanSalle modele ;
	
	public Plan(PlanSalle modele){
		super() ;
		this.modele = modele ;
		this.setBackground(Color.white) ;
	}
		
	public void paintComponent(Graphics g){
		super.paintComponent(g) ;
		Graphics2D g2d = (Graphics2D) g ;
		this.quadriller(g2d) ;
		this.placerPostes(g2d) ;
		this.tracerVisualisations(g2d) ;
	}
	
	private void quadriller(Graphics2D g){
		float dash[]={2f,0f,2f} ;
		BasicStroke pointilles = new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1.0f,dash,2f) ;
		g.setStroke(pointilles) ;
		for(int i = 1 ; i <= Parametres.NB_TRAVEES-1 ; i++){
			g.drawLine(Parametres.LARGEUR_TRAVEE*i,0,Parametres.LARGEUR_TRAVEE*i,Parametres.NB_RANGEES*Parametres.HAUTEUR_RANGEE-1) ;
		}
		for(int i = 1 ; i <= Parametres.NB_RANGEES-1 ; i++){
			g.drawLine(0,Parametres.HAUTEUR_RANGEE*i,Parametres.NB_TRAVEES*Parametres.LARGEUR_TRAVEE-1,Parametres.HAUTEUR_RANGEE*i) ;
		}
	}
	
	private void placerPostes(Graphics2D g){
		g.setStroke(new BasicStroke()) ;
		for(Poste poste : modele.listerPostes()){
			g.setColor(Color.gray) ;
			int xPoste = Parametres.posteX(poste.getPosition().getTravee(),poste.getOrientation()) ;
			int yPoste = Parametres.posteY(poste.getPosition().getRangee(),poste.getOrientation()) ;
			int xPersonne = Parametres.personneX(poste.getPosition().getTravee(),poste.getOrientation()) ;
			int yPersonne = Parametres.personneY(poste.getPosition().getRangee(),poste.getOrientation()) ;
			if(poste.getOrientation() == Orientation.NORD || poste.getOrientation() == Orientation.SUD){
				g.fill3DRect(xPoste,yPoste,Parametres.LONGUEUR_POSTE,Parametres.LARGEUR_POSTE,true) ;
			}
			else {
				g.fill3DRect(xPoste,yPoste,Parametres.LARGEUR_POSTE,Parametres.LONGUEUR_POSTE,true) ;
			}
			g.drawOval(xPersonne,yPersonne,Parametres.LARGEUR_PERSONNE,Parametres.LARGEUR_PERSONNE) ;
			if(poste.peutVoir()){
					g.setColor(Color.red) ;
			}
			else {
				g.setColor(Color.blue) ;
			}
			g.fillOval(xPersonne,yPersonne,20,20) ;
		}
	}
	
	private void tracerVisualisations(Graphics2D g){
		float dash[]={2f,0f,2f} ;
		BasicStroke pointilles = new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1.0f,dash,2f) ;
		g.setStroke(pointilles) ;
		g.setColor(Color.red) ;
		for(Poste poste : modele.listerPostes()){
			int centreX = Parametres.centrePersonneX(poste.getPosition().getTravee(),poste.getOrientation()) ;
			int centreY = Parametres.centrePersonneY(poste.getPosition().getRangee(),poste.getOrientation()) ;
			for(Poste posteVisible : poste.getPostesVisibles()){
				int visibleX = Parametres.centrePositionX(posteVisible.getPosition().getTravee()) ;
				int visibleY = Parametres.centrePositionY(posteVisible.getPosition().getRangee()) ;
				g.drawLine(centreX,centreY,visibleX,visibleY) ;
			}
		}
	}
	
}
