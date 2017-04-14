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
    currentAmmo = 0;
    return damage;
  }

  int refill(int receivedAmount) {
    int remainingRefill = receivedAmount;
    int emptySlots = maxAmmo - currentAmmo;

    if (receivedAmount >= emptySlots) {
      remainingRefill -= emptySlots;
      currentAmmo = maxAmmo;
    } else {
      currentAmmo += remainingRefill;
      remainingRefill = 0;
    }
    return remainingRefill;
  }

  String get_type() {
    String type = getClass().getSimpleName();
    return type;
  }

  String get_status() {
    String status = "Type: " + get_type()
            + " | Ammo: " + currentAmmo + " | Base damage: "
            + baseDamage + " | All Damage: " + currentAmmo * baseDamage;
    return status;
  }

}
