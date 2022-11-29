# 二叉树

## 树的种类
- 满二叉树
- 完全二叉树
- 二叉搜索树
- 平衡二叉树

## 树的存储
- 列表: 若从1开始计数，则左右孩子结点编号为2i, 2i+1; 若从0开始, 则2i+1, 2i+2;
- 链表

## 树的遍历
- 前中后序遍历(属于深度优先遍历)-递归法
- 前中后序遍历-迭代法
- 层序遍历(广度遍历)-迭代法

<font color=red>二叉树的遍历过程中，需要注意遍历结点和处理结点的关系</font>(这点在中序遍历的迭代法上尤为体现)。

## 二叉树的递归遍历
递归的三要素:

1. 确定递归函数的参数和返回值。确定哪些参数是递归过程中需要处理的，那么就在递归函数中加入这个参数，
并且明确每次递归的返回值是什么，从而确定递归函数的返回值。
2. 确定终止条件。操作系统是用一个栈的结构来保存每一层递归的信息，如果递归没有终止，操作系统的内存栈
必然就溢出。
3. 确定单层递归的逻辑。确定每一层递归需要处理的信息，在这里会重复调用自己来实现递归的过程。

## 二叉树的层序遍历
没什么好说的

## 做题思考: 
- 关于递归: 递归难点在于找到可以递归的点，如101题:
  1. 怎么判断一棵树是否对称？答：若所给根结点为空则对称，反之当它的左子树和右子树对称时，它对称。
  2. 怎么判断左子树和右子树对称？答：如果左树的左子树和右树的右子树对称，左树的右子树和右树的左子树对称，那么这个左树和右树对称。
  3. 以上内容体现了一个功能A我想实现，但我去实现A的时候又要用到A实现后的功能，即
     解决一个问题，需要先去解决它的类似子问题，等子问题解决，该问题自然而然地解决了。
  4. 当思考到这里，递归点已经出现: 尝试判断左树和右树对称的条件时，发现其跟两树的对称情况有关系。
  5. 如此，便可按照该思路去编写代码: 函数(左树, 右树) 功能是返回是否对称。
- 关于求高度/深度: 
  1. <font color="#00dd00">使用前序遍历可求从根结点到目标结点的结点数。
  2. 使用后序遍历可求从目标结点到根结点的结点数。</font>104题