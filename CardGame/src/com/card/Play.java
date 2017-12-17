package com.card;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Play {
    /**
     * 要求：
     *        1，创建一副扑克牌，包括四种花色：黑桃，红桃，梅花，方块
     *                          十三种点数：2-10，JQKA，不包括大小王
     *        2，创建两名玩家，至少有ID，姓名，手牌等属性
     *        3，洗牌，将之前的扑克牌打乱顺序
     *        4，将洗牌之后的扑克牌集合，从第一张开始发给两名玩家，按照一人一张的方式每人发两张
     *        5，游戏，比较两人手中最大的一张牌，若点数相等，则按花色比较，黑桃>红桃>梅花>方块
     */
    public  List<Cards> alldeck;
    String[] deck={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    String[] color={"黑桃","红桃","梅花","方块"};
    public User gamer1;
    public User gamer2;
    public Play(){
        alldeck=new ArrayList<Cards>();
    }
    public void addCard(){
    //初始化52[A-K]张扑克点数
        for (int i=0;i<4;i++){
            for(int j=0;j<13;j++){
            Cards first=new Cards(j+1, deck[j],color[i]);
            alldeck.add(first);
            }
        }
    }
    public void findDeck(){
        //输出添加后的扑克牌
        for (Cards f:alldeck
             ) {
            System.out.println(f.getName()+f.getId());
        }
    }

    public void shuffle(){
        //生成一个随机数用Collections.swap()方法与其洗牌
        Random random=new Random();
        for (int i=0;i<52;i++
             ) {
            int j=random.nextInt(52);
            Collections.shuffle(alldeck);

        }
    }
    public void gamer(){
        //用户手动输入玩家ID和姓名，手动生产两名玩家
        Scanner console=new Scanner(System.in);
        for(int i=0;i<2;i++) {
            System.out.println("请输入第"+(i+1)+"位玩家的ID和姓名");
            System.out.println("请输入id号");
            int id=console.nextInt();
            System.out.println("请输入玩家姓名");
            String name=console.next();
            if(i==0){
                gamer1=new User(id,name);
            }else {
                gamer2=new User(id,name);
            }
            System.out.println("玩家"+(i+1)+":"+gamer1.getName());

        }
    }
    public void playgame(){
        /**
         * 抽牌方法，玩家先抽牌，然后将值给玩家的手牌。
         */
        System.out.println("玩家"+gamer1.getName()+"抽牌");
        gamer1.userCards.add(alldeck.get(0));
        System.out.println("玩家"+gamer2.getName()+"抽牌");
        gamer2.userCards.add(alldeck.get(1));
        System.out.println("玩家"+gamer1.getName()+"抽牌");
        gamer1.userCards.add(alldeck.get(2));
        System.out.println("玩家"+gamer2.getName()+"抽牌");
        gamer2.userCards.add(alldeck.get(3));
    }
    public void sort(){
       /**
        *
       设置两个大整型来保存玩家手上最大的牌，然后线分别比较每个玩家手上的第一张和第二张牌的大小，如果一样大则比较用黑红梅方花色比较花色。
        */
        Cards gamer1max=null;//玩家1手牌的最大牌值
        Cards gamer2max=null;//玩家2手牌的最大牌值
        if(gamer1.userCards.get(0).getNumber() > gamer1.userCards.get(1).getNumber()) {
            gamer1max = gamer1.userCards.get(0);
            System.out.println("玩家:" + gamer1.getName() + "的最大手牌为:" + gamer1.userCards.get(0).getName() + gamer1.userCards.get(0).getId());
        }else  if(gamer1.userCards.get(0).getNumber() < gamer1.userCards.get(1).getNumber()){
            gamer1max = gamer1.userCards.get(1);
            System.out.println("玩家:" + gamer1.getName() + "的最大手牌为:" + gamer1.userCards.get(1).getName() + gamer1.userCards.get(1).getId());
        }else{
            Collections.sort(gamer1.userCards,new Compara());
            gamer1max=gamer1.userCards.get(1);
            System.out.println("玩家:" + gamer1.getName() + "的最大手牌为:" + gamer1.userCards.get(1).getName() + gamer1.userCards.get(1).getId());
}
        if(gamer2.userCards.get(0).getNumber() > gamer2.userCards.get(1).getNumber()) {
            gamer2max = gamer2.userCards.get(0);
            System.out.println("玩家:" + gamer2.getName() + "的最大手牌为:" + gamer2.userCards.get(0).getName() + gamer2.userCards.get(0).getId());
        }else if(gamer2.userCards.get(0).getNumber() < gamer2.userCards.get(1).getNumber()){
            gamer2max = gamer2.userCards.get(1);
            System.out.println("玩家:" + gamer2.getName() + "的最大手牌为:" + gamer2.userCards.get(1).getName() + gamer2.userCards.get(1).getId());
        }else {
            Collections.sort(gamer2.userCards,new Compara());
            gamer2max=gamer2.userCards.get(1);
            System.out.println("玩家:" + gamer2.getName() + "的最大手牌为:" + gamer2.userCards.get(1).getName() + gamer2.userCards.get(1).getId());
        }
        if(gamer1max.getNumber().intValue()>gamer2max.getNumber().intValue()){
            System.out.println("玩家"+gamer1.getName()+"获胜");
        }else {
            System.out.println("玩家"+gamer2.getName()+"获胜");
        }
    }
    public static void main(String[] args) {
    Play p=new Play();
        System.out.println("-----创建扑克牌-----");
   p.addCard();
        System.out.println("-----扑克牌创建成功-----");
//    p.find();
        System.out.println("-----开始洗牌-----");
        p.shuffle();
        System.out.println("-----洗牌结束-----");
        System.out.println("-----创建玩家-----");
      p.gamer();
        System.out.println("-----开始发牌-----");
      p.playgame();
        System.out.println("-----开始游戏-----");
      p.sort();

    }
}
