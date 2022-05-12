# Date: 27/11/2021

list = []


def outcomes(pass_c, defer_c, fail_c):
    """
    If the student passes all modules, they progress. If they pass all but one, they progress with a
    module trailer. If they pass less than all, they either progress with a module retriever or are
    excluded.

    :param pass_c: number of credits passed
    :param defer_c: number of credits deferred
    :param fail_c: number of credits failed
    """
    if pass_c == 120:
        print("Progress\n")
        list.append('Progress')
    elif pass_c == 100:
        print("Progress (module trailer)\n")
        list.append('Module trailer')
    elif pass_c == 60 or 40 or 20 or 0:
        if defer_c == 0 or defer_c < 20 or fail_c > 60:
            print("Exclude\n")
            list.append('Exclude')
        else:
            print("Module retriever\n")
            list.append('Module retriever')


def histogram():
    """
    It takes a list of strings, counts the number of times each string appears in the list, and prints a
    histogram of the results
    """
    progress = list.count('Progress')
    module_trailer = list.count('Module trailer')
    module_retriever = list.count('Module retriever')
    exclude = list.count('Exclude')
    print('-'*50)
    print(' Progress:  ', progress, ' :', ('*') * progress)
    print(' Trailer:   ', module_trailer, ' :', ('*') * module_trailer)
    print(' Retriever: ', module_retriever, ' :', ('*') * module_retriever)
    print(' Excluded:  ', exclude, ' :', ('*') * exclude)
    print('\n', len(list), 'outcomes in total.')
    print('-'*50)


def validation():
    """
    It takes three integers as input, checks that they are in the correct range and that they add up to
    120, then passes them to another function.
    """
    credits = [0, 20, 40, 60, 80, 100, 120]
    while True:
        while True:
            try:
                pass_c = int(input("\nPlease enter your credits at pass: "))
            except ValueError:
                print("Integer Required")
            else:
                if pass_c not in credits:
                    print("Out of range.")
                elif pass_c in credits:
                    try:
                        defer_c = int(
                            input("Please enter your credits at defer: "))
                    except ValueError:
                        print("Integer Required")
                    else:
                        if defer_c not in credits:
                            print("Out of range.")
                        elif defer_c in credits:
                            try:
                                fail_c = int(
                                    input("Please enter your credits at fail: "))
                            except ValueError:
                                print("Integer Required")
                            else:
                                if fail_c not in credits:
                                    print("Out of range.")
                                elif fail_c in credits:
                                    break
        if pass_c + defer_c + fail_c != 120:
            print('Total incorrect.')
            validation()
        else:
            outcomes(pass_c, defer_c, fail_c)
            try:
                cont = input(
                    "Would you like to enter another set of data?\nEnter 'y' for yes or 'q' to quit and view results: ")
                if cont == 'y':
                    continue
                else:
                    cont == 'q'
                    histogram()
                    # print(list)
                    break
            except ValueError:
                print("Please enter 'y' or 'q': ")
                break


validation()
