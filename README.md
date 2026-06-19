# 🎮 Game Studio Editor - Android

تطبيق محرر ألعاب ثلاثي الأبعاد كامل للأندرويد، يشبه Roblox Studio.

## المميزات ✨

- 🎨 **محرر 3D بصري** - رسم وتصميم الكائنات في بيئة ثلاثية الأبعاد
- 🏠 **أشكال هندسية** - مكعبات، كرات، أسطوانات، هرم
- 🖱️ **تحرير الخصائص** - موضع، حجم، لون، مادة
- 📦 **مستكشف الكائنات** - شجرة الهرمية للكائنات
- 🎮 **معاينة اللعبة** - تشغيل وتوقيف المحاكاة
- 💾 **حفظ وتحميل** - حفظ المشاريع محليا
- 🎨 **الإضاءة والظلال** - تأثيرات بصرية واقعية
- ✏️ **أدوات متقدمة** - أدوات الرسم والتحديد

## متطلبات التطوير

- Android Studio 4.1 أو أحدث
- Android SDK 21 (API Level 21) أو أحدث
- Java 8 أو أحدث
- Gradle 7.0 أو أحدث

## البدء السريع

### 1. استنساخ المستودع
```bash
git clone https://github.com/jgjfift2-code/game-studio-editor.git
cd game-studio-editor
```

### 2. فتح في Android Studio
- اختر File → Open
- اختر مجلد المشروع
- انتظر Gradle sync

### 3. تشغيل التطبيق
- اختر جهاز افتراضي أو هاتف متصل
- اضغط Shift + F10 أو Run → Run 'app'

## هيكل المشروع

```
game-studio-editor/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/gameStudioEditor/
│   │   │   │   ├── MainActivity.java          # النشاط الرئيسي
│   │   │   │   ├── GameRenderer.java          # محرك العرض 3D
│   │   │   │   ├── GameObject.java            # كائن اللعبة الأساسي
│   │   │   │   ├── ObjectManager.java         # إدارة الكائنات
│   │   │   │   ├── PropertyPanel.java         # لوحة الخصائص
│   │   │   │   ├── ObjectExplorer.java        # مستكشف الكائنات
│   │   │   │   ├── GameSimulator.java         # محاكاة اللعبة
│   │   │   │   ├── ProjectManager.java        # إدارة المشاريع
│   │   │   │   ├── ShapeFactory.java          # مصنع الأشكال
│   │   │   │   └── Utils.java                 # أدوات مساعدة
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── property_panel.xml
│   │   │   │   │   └── object_explorer.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── styles.xml
│   │   │   │   └── drawable/
│   │   │   └── AndroidManifest.xml
│   │   └── test/ & androidTest/
│   └── build.gradle
├── .gitignore
├── build.gradle
├── settings.gradle
├── README.md
└── LICENSE
```

## الاستخدام

### إضافة كائن جديد
1. اضغط على زر "+" في الأعلى
2. اختر نوع الشكل (مكعب، كرة، إلخ)
3. سيظهر الشكل في المحرر

### تعديل الخصائص
1. اختر كائن من مستكشف الكائنات
2. غيّر الموضع، الحجم، اللون في لوحة الخصائص
3. التغييرات تُطبق مباشرة

### حفظ المشروع
1. اضغط Ctrl+S أو File → Save
2. اختر مكان الحفظ
3. سيتم حفظ كل الكائنات والخصائص

### تشغيل اللعبة
1. اضغط زر "Play" الأخضر
2. ستدخل وضع المحاكاة
3. اضغط "Stop" للعودة للتحرير

## المكتبات المستخدمة

- **OpenGL ES** - رسوميات 3D
- **Android Material Design** - واجهة المستخدم
- **Gson** - تسلسل JSON
- **AndroidX** - مكتبات الدعم

## المساهمة

نرحب بالمساهمات! يرجى:

1. عمل Fork للمشروع
2. إنشاء فرع للميزة (`git checkout -b feature/AmazingFeature`)
3. Commit التغييرات (`git commit -m 'Add some AmazingFeature'`)
4. Push إلى الفرع (`git push origin feature/AmazingFeature`)
5. فتح Pull Request

للمزيد، انظر [CONTRIBUTING.md](CONTRIBUTING.md)

## الترخيص

هذا المشروع مرخص تحت MIT License - انظر ملف LICENSE للتفاصيل.

## المؤلفون

- **jgjfift2-code** - المؤلف الأساسي

## الدعم

إذا واجهت مشاكل أو لديك أسئلة:
- 📧 افتح Issue على GitHub
- 💬 اترك تعليق في المشروع
- 🐛 أبلّغ عن الأخطاء بالتفصيل

## الخارطة الطريقية 🗺️

- [ ] إضافة محرر النصوص البرمجية (Lua/Java)
- [ ] دعم الفيزياء
- [ ] نظام الجزيئات
- [ ] المؤثرات الصوتية
- [ ] النشر على متجر Google Play
- [ ] دعم Multiplayer
- [ ] مكتبة الأصول المدمجة

---

**استمتع ببناء ألعابك! 🎮✨**
