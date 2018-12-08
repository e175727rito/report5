package jp.ac.uryukyu.ie.e175727;
/**
 * EnemyクラスとHeroクラスのスーパークラス
 * EnemyクラスとHeroクラスでは重複する部分が多く、修正部分が必要な時
 * に手間がかかるため、両方に共通するクラスを作った。
 * String name 相手の名前
 * int hitpoint 相手のHP
 * int attack　相手の攻撃力
 * boolean dead 相手の生死状態
 */

public class LivingThing {

    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     *コンストラクタ
     * @param name　名前
     * @param maximumHP　最大HP
     * @param attack　攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * 死亡判定を行うメソッド
     * @return boolean型でtrueなら死亡
     */
    public boolean isDead(){
        return dead;
    }

    /**
     * 名前を戻り値とするゲッターメソッド
     * @return 名前
     */
    public String getName(){
        return name;
    }

    /**
     * 敵を攻撃するattackメソッド
     * @param opponent　攻撃対象
     */
    public void attack(LivingThing opponent) {
        if(dead == false){
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自分がどれくらいダメージを受けたかを計算するメソッド
     * @param damage　受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    /**
     * hitPointのゲッターメソッド
     * @return HP
     */
    public int getHitPoint() {
        return hitPoint;
    }

    /**
     * hitPointのセッターメソッド
     * @param hitPoint HP
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * deadのセッターメソッド
     * @param dead 生死状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }
}

