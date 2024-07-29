@regression
Feature: Ideasoft test senaryoları

  Scenario Outline: Sepete ürün ekleme
    Given Ideasoft web sitesine gidilir
    When Arama alanına "<product>" yazılır
    And Arama butonuna tıklanır
    Then "<product>" ürününün listelendiği kontrol edilir
    And Listelenen üründen "<quantity>" adet sepete eklenir
    And "<message>" yazısının görünmesi kontrol edilir
    And Sepet menüsüne tıklanır
    Then Sepet içeriğinde ilgili üründen "<quantity>" olduğu kontrol edilir

    Examples:
      |product|quantity| message |
      | Ürün  | 5  |SEPETİNİZE EKLENMİŞTİR |

  Scenario Outline: Başarılı üye girişi
    Given Ideasoft web sitesine gidilir
    And Giriş Yap menüsüne tıklanır
    Then Giriş yap metni kontrol edilir
    When İlgili alanlara "<email>" "<sifre>" üyelik bilgileri girilir
    And Giriş yap butonuna tıklanır
    Then Başarılı üye girişi yapıldığı kontrol edilir

    Examples:
      |email               |sifre   |
      |itsmeyesim@gmail.com|testoto321|

  Scenario Outline: Yeni üyelik
    Given Ideasoft web sitesine gidilir
    When Giriş Yap menüsüne tıklanır
    Then Henüz üye değil misiniz metni kontrol edilir
    And Hemen Üye Ol butonuna tıklanır
    Then Yeni üyelik sayfasına gidildiği kontrol edilir
    When İlgili alanlara "<ad>" "<soyad>" "<email>" "<sifre>" "<phone>" üyelik bilgileri girilir
    And Sözleşmeler ve captcha onaylanır
    And Kaydet butonuna tıklanır

    Examples:
      |ad     | soyad      |email               |sifre   |phone     |
      |test  | otomasyon  |itsmeyesim@gmail.com|testoto321|55555555555|
