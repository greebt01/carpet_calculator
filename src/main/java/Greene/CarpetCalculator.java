package Greene;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CarpetCalculator implements Calculatable {
    NumberFormat nf=NumberFormat.getCurrencyInstance();
    private ArrayList<Room> building;
    private float subTotal=0, discount=1.00f, totalAfterDisc=0, pricePerSqFoot, installCharge;
    private final float percentageConversionFactor=100;
    public CarpetCalculator(float pricePerSqFoot) {
        this.building=new ArrayList<>();
        this.pricePerSqFoot=pricePerSqFoot;
    }

    public CarpetCalculator(float pricePerSqFoot, float installCharge) {
        this.building=new ArrayList<>();
        this.pricePerSqFoot=pricePerSqFoot;
        this.installCharge=installCharge;
    }

    @Override
    public void addRoom(Room room) {
        building.add(room);

    }

    @Override
    public String getTotalCost() {
        for (Room room:building) {
            subTotal+=(room.getArea()*pricePerSqFoot);
            totalAfterDisc=(subTotal+installCharge)*discount;
        }
        return nf.format(totalAfterDisc);
    }

    @Override
    public void addPercentDiscount(float percentDiscount) {
        discount=(1.00f-(percentDiscount/percentageConversionFactor));

    }
}
