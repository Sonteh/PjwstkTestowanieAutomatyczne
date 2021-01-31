# PjwstkTestowanieAutomatyczne

# LAB5

Pick one of the testing frameworks from that list https://en.wikipedia.org/wiki/List_of_unit_testing_frameworks and make simple tutorial.

## PyTest

PyTest enables you to make simple, easy and scalable tests. Tests are expressive and readable.

### Instalation

You need to have installed <b>pip</b>. It should be already on your PC if you are using Python 2 >= 2.7.9 or Python 3 >= 3.4 <br>
Try checking the pip version with following command if you are on Windows <br>
`py -m pip --version`

- Run the following comand to install PyTest <br>
`pip install -U pytest`

- Check if you have installed correct version <br>
`pytest --version`

### Simple first test
This is just a simple test function which reports failure, because `func(3)` does not return `5`.

```python
def func(x):
  return x + 1
  
def test_answer():
  assert func(3) == 5
```
If you execute the test function you recive following report
```python
=========================== test session starts ============================
platform linux -- Python 3.x.y, pytest-6.x.y, py-1.x.y, pluggy-0.x.y
cachedir: $PYTHON_PREFIX/.pytest_cache
rootdir: $REGENDOC_TMPDIR
collected 1 item

test_sample.py F                                                     [100%]

================================= FAILURES =================================
_______________________________ test_answer ________________________________

    def test_answer():
>       assert func(3) == 5
E       assert 4 == 5
E        +  where 4 = func(3)

test_sample.py:6: AssertionError
========================= short test summary info ==========================
FAILED test_sample.py::test_answer - assert 4 == 5
============================ 1 failed in 0.12s =============================
```

### You can also group multiple tests in a class

Once you develop multiple tests it might be worth grouping and putting them into a class.

```python
class TestClass:
    def test_one(self):
        x = "this"
        assert "h" in x

    def test_two(self):
        x = "hello"
        assert hasattr(x, "check")
```

PyTest discovers all tests following its Conventions for Python test discovery, so it finds both `test_` prefixed function. <br>
Making test classes just make sure you prefix the class name with `Test`.

```python
================================= FAILURES =================================
____________________________ TestClass.test_two ____________________________

self = <test_class.TestClass object at 0xdeadbeef>

    def test_two(self):
        x = "hello"
>       assert hasattr(x, "check")
E       AssertionError: assert False
E        +  where False = hasattr('hello', 'check')

test_class.py:8: AssertionError
========================= short test summary info ==========================
FAILED test_class.py::TestClass::test_two - AssertionError: assert False
1 failed, 1 passed in 0.12s
```

The first test passed and the second failed. You can easily see the intermediate values in the assertion to help you understand the reason for the failure.
