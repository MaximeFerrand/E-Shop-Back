package ajc.sopra.eshop.model;

import javax.persistence.Embeddable;


public enum OrderTracking {
	ordered,inPreparation, shipped, delivered, closed;
	
	/*private OrderTracking() {
		
	}*/

}
