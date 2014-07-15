/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs545;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author BMX
 */
@Named("tea")
@SessionScoped
public class TeaBean implements Serializable {

    private ArrayList<Tea> teas;
    private Set<String> types;
    private String selectedType = "All";
    private ArrayList<Tea> teasOfSelectedType;
    private String selectedTeaName = "";
    private double totalAmount = 0;
    private ArrayList<Tea> selectedTeas;
    private String selectedPage = "mainContent";
    private People customer;

    public TeaBean() {
        initData();
        teasOfSelectedType = new ArrayList<Tea>();
        selectedTeas = new ArrayList<Tea>();
        types = new TreeSet<String>();
        customer = new People();
    }

    private SelectItem[] typeItems = {
        new SelectItem("All", "All"),
        new SelectItem("Dark", "Dark"),
        new SelectItem("Green", "Green"),
        new SelectItem("Oolong", "Oolong"),
        new SelectItem("Herbal", "Herbal"),
        new SelectItem("Rooibos", "Rooibos"),
        new SelectItem("Mate", "Mate")
    };

    public void initData() {
        teas = new ArrayList<Tea>();
        //BLACK TEAS
        teas.add(new Tea("Black Dragon Pearls", "Rare spring-harvested black tea pearls are as coveted as the legendary gems they were inspired by. Just as their bejeweled counterparts take years to become perfection, each tea pearl consists of 30 leaves and buds handpicked and immediately rolled before the leaves can dry. The famed pearls carry sweet undertones of chocolate, creating exquisitely smooth body in each cup. ", "/images/31397_d.jpg", "Dark", 10));
        teas.add(new Tea("MASALA CHAI BLACK TEA", "The height of this culinary classic takes an ancient and traditional chai mix mix of whole cloves, warm cinnamon, piquant ginger, and anise and modernizes it with India's famed fragrant masala spices of coriander and cardamom, taking you on a sublime, savory tea journey. ", "images/31619_d.jpg", "Dark", 20));
        teas.add(new Tea("CHAMPAGNE SANGRIA PUNCH BLACK TEA", "Colorful as a drive along the Mediterranean coast, this flavored black is deep, complex and full of personality. Red rich grapes, tangy orange slices, juicy peach and crisp apple spring to life with a hint of sweet cinnamon, creating a magical elixir certain to awaken your taste buds. ", "images/31498_d.jpg", "Dark", 30));
        teas.add(new Tea("WEIGHT TO GO! PU-ERH TEA", "Enticing and tantalizing, this rosy blush blend of pu-erh black and green oolong teas merge to create an intoxicating mix of sweet fruit with bright mint. Sweet strawberries and golden delicious apples swirl into peppermint and spearmint and create guilt-free beauty inside and out. ", "images/10004451_d.jpg", "Dark", 40));

        //GREEN TEAS
        teas.add(new Tea("STRAWBERRY GRAPEFRUIT XUE LONG GREEN TEA", "Strawberry, apple, sliced orange, and lemongrass are complemented with a squeeze of tart grapefruit flavor and then balanced with soft notes of marigold and hibiscus. Best over ice, this invigorating green tea infusion swirls sweet and tart together for a refreshing tea as unique as you. ", "/images/31834_d.jpg", "Green", 15));
        teas.add(new Tea("JEJU ISLAND GREEN TEA", "Cultivated in the southernmost tip of Korea on Jeju Island, this pure and clean gem is as bright and lush as the island's beautiful countryside. The green tea leaves are gently twisted into a crescent shape, making this a special cup to enliven your senses as it stirs your soul. ", "images/31410_d.jpg", "Green", 25));
        teas.add(new Tea("JADE CITRUS MINT GREEN TEA", "Refreshing and invigorating, this green tea blend is a bright citrus balance of lemon verbena and lemongrass with a hint of spearmint and rich China Chun Mee green tea base. \n"
                + "\n"
                + "Bright citrus balance of lemon verbena and lemongrass with a hint of spearmintand rich China Chun Mee green tea base", "images/31504_d.jpg", "Green", 35));
        teas.add(new Tea("MATCHA JAPANESE GREEN TEA", "Since the 12th Century, this green tea has been used in the traditional Japanese tea ceremony 'chado', known as the 'Way of Tea'. The entire leaf is delicately ground into a silky smooth, chartreuse colored powder. With naturally occurring vitamin C, potassium, iron, and fiber, this is a wonderful alternative to a morning cup of coffee. ", "images/31401 000 080_d.jpg", "Green", 40));
    }

    public ArrayList<Tea> getTeas() {
        return teas;
    }

    public void setTeas(ArrayList<Tea> teas) {
        this.teas = teas;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }

    public SelectItem[] getTypeItems() {
        return typeItems;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public String setSelectedTypeFromAction(String selectedType) {
        this.selectedType = selectedType;
        this.selectedPage = "mainContent";
        return null;
    }

    public String setSelectedPageFromAction(String pageName) {
        this.selectedPage = pageName;
        return null;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }

    public ArrayList<Tea> getTeasOfSelectedType() {
        teasOfSelectedType.clear();

        for (Tea tea : teas) {
            if (this.selectedType.equalsIgnoreCase("all") || tea.getType().equals(this.selectedType)) {
                teasOfSelectedType.add(tea);
            }
        }

        return teasOfSelectedType;
    }

    public ArrayList<Tea> getAddedTeas() {
        teasOfSelectedType.clear();

        for (Tea tea : teas) {
            if (tea.isSelect()) {
                teasOfSelectedType.add(tea);
            }
        }

        return teasOfSelectedType;
    }

    public int getNumberOfSelectedType() {
        return teasOfSelectedType.size();
    }

    public String getSelectedTeaName() {
        return selectedTeaName;
    }

    public void setSelectedTeaName(String selectedTeaName) {
        this.selectedTeaName = selectedTeaName;
    }

    public Tea getSelectedTeaObject() {
        for (Tea tea : teas) {
            if (tea.getName().equals(this.selectedTeaName)) {
                return tea;
            }
        }

        return null;
    }

    public double getTotalAmount() {
        double total = 0;
        for (Tea tea : this.teasOfSelectedType) {
            total += tea.getTotalPrice();
        }

        totalAmount = total;
        return totalAmount;
    }

    public ArrayList<Tea> getSelectedTeas() {
        selectedTeas.clear();

        for (Tea tea : teasOfSelectedType) {
            if (tea.isSelect()) {
                selectedTeas.add(tea);
            }
        }

        return selectedTeas;
    }

    public void addToBag(String name) {
        for (Tea tea : teas) {
            if (tea.getName().equalsIgnoreCase(name)) {
                tea.setSelect(true);
                return;
            }
        }
    }

    public String getSelectedPage() {
        return selectedPage;
    }

    public String setSelectedPage(String selectedPage) {
        this.selectedPage = selectedPage;
        return "indexFacelet";
    }

    public People getCustomer() {
        return customer;
    }

}
