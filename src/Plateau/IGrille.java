package Plateau;

import Cartes.Carte;
import Cartes.ICarte;

import java.util.List;

public interface IGrille<T extends ICarte>  {

    public void pick(int i);

    public void del(ICarte carte1, ICarte carte2);

    public List<Carte> set(List carteList);

    public void move(ICarte carte1, ICarte carte2);

}
