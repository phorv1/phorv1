package arcraftapp;

public class Aircraft {
  int currentAmmo, maxAmmo, baseDamage;

  public Aircraft() {
    currentAmmo = 0;
  }

  public Aircraft(int maxAmmo, int baseDamage) {
    this.maxAmmo = maxAmmo;
    this.baseDamage = baseDamage;
  }

  int fight() {
    int damage = currentAmmo * baseDamage;
    return damage;
  }

}

