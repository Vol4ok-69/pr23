## Создание структуры проекта в соответствии с паттерном MVVM

Данный проект представляет собой Android-приложение, разработанное на Kotlin в Android Studio с использованием архитектурного паттерна MVVM.

Проект реализует:

* нижнее меню навигации;
* работу RadioButton;
* отображение Google Maps;
* построение маршрута;
* ProgressBar;
* переходы между экранами;
* использование ViewModel и StateFlow;
* разделение проекта по слоям.

Практическая работа выполнена в соответствии с методическими указаниями №23.

---

# Цель работы

Изучить:

* организацию структуры Android-проекта;
* паттерн MVVM;
* Navigation Component;
* работу Fragment;
* работу ViewModel;
* StateFlow;
* отображение карт Google Maps;
* организацию навигации между экранами.

---

# Используемые технологии

| Технология           | Назначение                    |
| -------------------- | ----------------------------- |
| Kotlin               | Язык разработки               |
| Android SDK          | Разработка Android-приложения |
| XML Layout           | Интерфейс                     |
| Fragment             | Экраны приложения             |
| Navigation Component | Навигация                     |
| ViewModel            | Управление состоянием         |
| StateFlow            | Реактивные данные             |
| Google Maps SDK      | Карта и маршрут               |
| Material Components  | UI компоненты                 |
| MVVM                 | Архитектура проекта           |

---

# Архитектура проекта

Проект реализован по паттерну MVVM:

* Model;
* View;
* ViewModel.

Структура проекта разделена по слоям. 

```text
data/
model/
ui/
viewmodel/
utils/
```

---

# Структура проекта

Основная структура проекта: 

```text
com.example.pr23
├── data
├── model
├── ui
├── utils
├── viewmodel
└── MainActivity.kt
```

---

# Назначение папок

| Папка     | Назначение             |
| --------- | ---------------------- |
| data      | Источник данных        |
| model     | Модели приложения      |
| ui        | Fragment экраны        |
| viewmodel | ViewModel приложения   |
| utils     | Вспомогательные методы |

---

# Реализованные экраны

В приложении реализованы экраны:

1. Wallet;
2. Add Payment Method;
3. Tracking Package;
4. Delivery Successful.

---

# 1. Экран Wallet

Файл:

```text
WalletFragment.kt
```

Экран содержит:

* баланс кошелька;
* выбранный способ оплаты;
* статус доставки;
* кнопки перехода между экранами.

---

# Функционал Wallet

Кнопки:

```kotlin
addPaymentButton
trackPackageButton
deliveryStatusButton
```

используют:

```kotlin
findNavController().navigate(...)
```

для переходов между Fragment.

---

# Обновление состояния

Wallet получает данные из:

```kotlin
SharedViewModel
```

Используется:

```kotlin
collectWhenStarted
```

и:

```kotlin
StateFlow
```

---

# 2. Экран Add Payment Method

Файл:

```text
AddPaymentFragment.kt
```

Экран реализует:

* RadioButton;
* выбор способа оплаты;
* отображение описания метода оплаты.

---

# Работа RadioButton

Используется:

```kotlin
paymentRadioGroup.setOnCheckedChangeListener
```

При выборе:

```kotlin
viewModel.selectPaymentMethod(...)
```

обновляется:

* выбранный метод оплаты;
* текст описания;
* состояние интерфейса.

---

# Методы оплаты

Модели создаются в:

```text
MockRepository.kt
```

Используются:

```kotlin
PaymentMethod
```

Доступны:

* Банковская карта;
* Наличные;
* Delivery Wallet.

---

# 3. Экран Tracking Package

Файл:

```text
TrackingFragment.kt
```

Экран реализует:

* Google Maps;
* отображение маршрута;
* маркеры точек доставки;
* линию маршрута.

---

# Инициализация карты

Используется:

```kotlin
SupportMapFragment
```

и:

```kotlin
getMapAsync
```

После загрузки карты:

* добавляются точки;
* отображается маршрут;
* строится камера карты.

---

# Маршрут доставки

Данные маршрута:

```kotlin
RoutePoint
```

получаются из:

```kotlin
MockRepository
```

Точки маршрута:

* Склад;
* Сортировочный центр;
* Курьер в пути;
* Адрес доставки.

---

# Отображение линии маршрута

Используется:

```kotlin
PolylineOptions()
```

Линия соединяет все точки маршрута.

---

# Маркеры на карте

Используется:

```kotlin
MarkerOptions()
```

Каждая точка имеет:

* координаты;
* название.

---

# 4. Экран Delivery Successful

Файл:

```text
DeliveryFragment.kt
```

Экран реализует:

* ProgressBar;
* статус доставки;
* анимацию прогресса;
* повтор анимации.

---

# Работа ProgressBar

Прогресс обновляется через:

```kotlin
StateFlow<DeliveryState>
```

Во ViewModel:

```kotlin
startDeliveryProgress()
```

постепенно увеличивает значение:

```kotlin
0..100 step 5
```

с задержкой:

```kotlin
delay(250)
```

---

# Статусы доставки

Метод:

```kotlin
buildStatusText()
```

возвращает:

* Посылка оформлена;
* Курьер забрал отправление;
* Посылка движется по маршруту;
* Курьер рядом с получателем;
* Доставка успешно завершена.

---

# SharedViewModel

Файл:

```text
SharedViewModel.kt
```

ViewModel хранит:

* список способов оплаты;
* выбранный метод оплаты;
* маршрут доставки;
* состояние доставки.

---

# Использование StateFlow

Используется:

```kotlin
MutableStateFlow
```

и:

```kotlin
asStateFlow()
```

Это позволяет:

* централизованно хранить состояние;
* автоматически обновлять UI;
* разделять данные между Fragment.

---

# Navigation Component

Навигация реализована через:

```text
nav_graph.xml
```

Используются:

```kotlin
NavHostFragment
NavController
```

---

# Нижнее меню

Файл:

```text
bottom_nav_menu.xml
```

Содержит:

* Wallet;
* Payment;
* Tracking;
* Success.

---

# MainActivity

Файл:

```text
MainActivity.kt
```

MainActivity:

* подключает Navigation;
* инициализирует BottomNavigationView;
* управляет переходами между экранами.

---

# Работа с Google Maps

Для карты используется:

```kotlin
Google Maps SDK
```

Разрешение:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

API ключ задаётся в:

```xml
google_maps_api_key
```

---

# Векторная графика

Все изображения реализованы в формате:

```text
VectorDrawable
```

Используются:

* ic_wallet.xml;
* ic_payment.xml;
* ic_tracking.xml;
* ic_success.xml;
* ic_app_logo.xml.

---

# Логотип приложения

Логотип:

```text
ic_app_logo.xml
```

используется как:

* иконка интерфейса;
* значок приложения.

---

# Использование FragmentExtensions

Файл:

```text
FragmentExtensions.kt
```

Содержит:

```kotlin
collectWhenStarted()
```

Функция упрощает:

* lifecycle-aware collect;
* работу с coroutine;
* безопасный collect Flow.

---

# Что показать на защите

## 1. Нижнее меню

Показать:

* переходы между всеми экранами;
* работу BottomNavigationView.

---

## 2. Add Payment Method

Показать:

* выбор RadioButton;
* изменение выбранного способа оплаты.

---

## 3. Tracking Package

Показать:

* карту;
* маркеры;
* маршрут.

---

## 4. Delivery Successful

Показать:

* ProgressBar;
* изменение статусов;
* повтор анимации.

---

## 5. MVVM

Объяснить:

* разделение проекта по слоям;
* работу ViewModel;
* использование StateFlow.

---

# Что говорить преподавателю

## Почему используется MVVM

«MVVM разделяет интерфейс, данные и бизнес-логику, благодаря чему проект становится более поддерживаемым.»

---

## Почему используется SharedViewModel

«SharedViewModel позволяет хранить общее состояние между Fragment.»

---

## Почему используется StateFlow

«StateFlow обеспечивает реактивное обновление интерфейса.»

---

## Почему Navigation Component

«Navigation Component упрощает навигацию и управление Fragment.»

---

## Почему используется Repository

«Repository изолирует источник данных от UI слоя.»

---

# Вывод

В ходе выполнения практической работы было разработано Android-приложение с архитектурой MVVM. Реализованы навигация между экранами, работа RadioButton, отображение карты и маршрута, ProgressBar и централизованное управление состоянием через ViewModel и StateFlow. Структура проекта разделена по слоям в соответствии с паттерном MVVM.
