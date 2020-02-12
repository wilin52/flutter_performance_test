import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

const double itemHeight = 40.0;
const int scrollOffset = 10000;

class FlutterList extends StatefulWidget {
  @override
  _FlutterListState createState() => _FlutterListState();
}

class _FlutterListState extends State<FlutterList> {
  ScrollController controller = ScrollController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.builder(
        controller: controller,
        itemBuilder: (context, index) {
//          return Container(
//            padding: EdgeInsets.only(left: 5, right: 5),
//            height: itemHeight,
//            child: Center(child: Text("$index")),
//            decoration: UnderlineTabIndicator(
//                borderSide:
//                    const BorderSide(width: 0.5, color: Colors.black12)),
//          );
          return Container(
              padding: EdgeInsets.only(left: 5, right: 5),
              height: itemHeight,
              alignment: Alignment.center,
              child: Image.asset("images/local_image.png"));
        },
        itemCount: 1000,
        itemExtent: itemHeight,

        /// TODO 测试影响。
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          if (controller.offset == 0) {
            controller.animateTo(10000,
                duration: Duration(milliseconds: scrollOffset ~/ 7),
                curve: Curves.easeInOutSine);
          } else {
            controller.animateTo(0,
                duration: Duration(milliseconds: scrollOffset ~/ 7),
                curve: Curves.easeInOutSine);
          }
        },
      ),
    );
  }
}
